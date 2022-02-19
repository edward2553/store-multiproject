package co.com.poli.serviceproduct.repository;

import co.com.poli.serviceproduct.entities.Category;
import co.com.poli.serviceproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
