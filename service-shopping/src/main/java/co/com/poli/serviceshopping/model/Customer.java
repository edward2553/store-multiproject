package co.com.poli.serviceshopping.model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String numberID;
    private String name;
    private String email;
}
