package co.com.poli.serviceproduct;

import co.com.poli.serviceproduct.entities.Category;
import co.com.poli.serviceproduct.entities.Product;
import co.com.poli.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void when_findByCategory_return_ListProducts(){
        Product product = Product.builder()
                .name("juguete")
                .price(100000.0)
                .stock(100.0)
                .category(Category.builder().id(1L).build())
                .build();
        productRepository.save(product);
        List<Product> products = productRepository.findByCategory(product.getCategory());
        Assertions.assertThat(products.size()).isEqualTo(2);
    }

}
