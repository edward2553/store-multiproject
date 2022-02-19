package co.com.poli.servicecustomer.service;

import co.com.poli.servicecustomer.entities.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void delete(Customer customer);
    List<Customer> findAll();
    Customer findById(Long id);
    Customer findByNumberID(String numberID);
}
