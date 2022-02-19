package co.com.poli.serviceshopping.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Double stock;
}
