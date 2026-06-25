package com.ecomerce.customer.model.customerservice;

import com.ecomerce.customer.model.dtos.costomerreqdto;
import com.ecomerce.customer.model.dtos.customerUpdateDto;
import com.ecomerce.customer.model.dtos.customerresponsedto;
import com.ecomerce.customer.model.entity.customer;
import com.ecomerce.customer.model.exceptions.customerExistsException;
import com.ecomerce.customer.model.exceptions.customerNotFoundException;
import com.ecomerce.customer.model.repository.customerrepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class customerService implements customerServ {
   private final customerrepo customerrepo;
   private final ModelMapper modelMapper;

    @Override
    public customerresponsedto saveCustomer(costomerreqdto costomerreqdto) throws customerExistsException {
        customer customer = modelMapper.map(costomerreqdto, customer.class);
        return modelMapper.map(customerrepo.save(customer),customerresponsedto.class);
    }

    @Override
    public customerresponsedto updateCustomer(customerUpdateDto customerUpdateDto) throws customerNotFoundException {
        Optional<customer> updateCustomer = customerrepo.findById(customerUpdateDto.getId());
        customer customer;
        if (updateCustomer.isEmpty()) {
            throw new customerNotFoundException("Customer not found with id" + customerUpdateDto.getId());
        } else {
            customer = updateCustomer.get();
            customer.setName(customerUpdateDto.getName());
            customer.setEmail(customerUpdateDto.getEmail());
            customer.setAddress(customerUpdateDto.getAddress());
            customer.setPhone(customerUpdateDto.getPhone());
        }
        return modelMapper.map(customerrepo.save(customer), customerresponsedto.class);
    }

    @Override
    public customerresponsedto deleteCustomer(Long id) throws customerNotFoundException {

        Optional<customer> customer = customerrepo.findById(id);
        if (customer.isEmpty()) {
            throw new customerNotFoundException("Customer not found with id" + id);
        } else {
            customerrepo.deleteById(id);
        }
        return null;
    }

    @Override
    public customerresponsedto getCustomerById(Long id) throws customerNotFoundException {
        Optional<customer> customer = customerrepo.findById(id);

        // Implementation for retrieving a customer
        return modelMapper.map(customer, customerresponsedto.class);
    }

    @Override
    public List<customerresponsedto> getAllCustomers() {
        return customerrepo.findAll().stream().map(customer -> modelMapper.map(customer, customerresponsedto.class)).toList();
    }
}
