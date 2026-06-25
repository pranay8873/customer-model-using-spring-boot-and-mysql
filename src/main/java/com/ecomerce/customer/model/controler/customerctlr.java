package com.ecomerce.customer.model.controler;

import com.ecomerce.customer.model.customerservice.customerService;
import com.ecomerce.customer.model.dtos.costomerreqdto;
import com.ecomerce.customer.model.dtos.customerUpdateDto;
import com.ecomerce.customer.model.dtos.customerresponsedto;
import com.ecomerce.customer.model.exceptions.customerExistsException;
import com.ecomerce.customer.model.exceptions.customerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class customerctlr {
    @Autowired
    private customerService customerService;

    @PostMapping("/save")
    public ResponseEntity<customerresponsedto> saveCustomer(costomerreqdto costomerreqdto) throws customerExistsException {
        return ResponseEntity.ok(customerService.saveCustomer(costomerreqdto));
    }
    @PostMapping("/update")
    public ResponseEntity<customerresponsedto> updateCustomer(@PathVariable Long id, @RequestBody customerUpdateDto customerUpdateDto) {
        return ResponseEntity.ok(customerService.updateCustomer(customerUpdateDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<customerresponsedto> getCustomerById(@PathVariable Long id) throws customerNotFoundException {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @GetMapping("/getall")
    public ResponseEntity<List<customerresponsedto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }


}
