package com.ecomerce.customer.model.customerservice;

import com.ecomerce.customer.model.dtos.costomerreqdto;
import com.ecomerce.customer.model.dtos.customerUpdateDto;
import com.ecomerce.customer.model.dtos.customerresponsedto;
import com.ecomerce.customer.model.exceptions.customerExistsException;
import com.ecomerce.customer.model.exceptions.customerNotFoundException;

import java.util.List;

public interface customerServ {


    customerresponsedto saveCustomer(costomerreqdto costomerreqdto)
             throws customerExistsException;
     customerresponsedto updateCustomer(customerUpdateDto costomerUpdateDto)
             throws customerNotFoundException;
     customerresponsedto deleteCustomer(Long id)
             throws customerNotFoundException;
     customerresponsedto getCustomerById(Long id)
             throws customerNotFoundException;
     List<customerresponsedto> getAllCustomers();

}
