package com.ecomerce.customer.model.dtos;

import com.ecomerce.customer.model.enums.Gender;
import com.ecomerce.customer.model.enums.role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class customerresponsedto {

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
