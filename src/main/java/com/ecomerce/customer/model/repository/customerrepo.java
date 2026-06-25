package com.ecomerce.customer.model.repository;

import com.ecomerce.customer.model.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerrepo extends JpaRepository<customer,Long> {

    customer findByEmail(String email);

}
