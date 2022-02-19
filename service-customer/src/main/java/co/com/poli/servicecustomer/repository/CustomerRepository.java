package co.com.poli.servicecustomer.repository;

import co.com.poli.servicecustomer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNumberId(String numberId);
}
