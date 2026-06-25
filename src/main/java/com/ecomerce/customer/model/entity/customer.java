package com.ecomerce.customer.model.entity;

import com.ecomerce.customer.model.enums.Gender;
import com.ecomerce.customer.model.enums.role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private role role;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
