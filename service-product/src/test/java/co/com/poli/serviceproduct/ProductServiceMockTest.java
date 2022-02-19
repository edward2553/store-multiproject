package co.com.poli.serviceproduct;

import co.com.poli.serviceproduct.entities.Category;
import co.com.poli.serviceproduct.entities.Product;
import co.com.poli.serviceproduct.repository.ProductRepository;
import co.com.poli.serviceproduct.service.ProductService;
import co.com.poli.serviceproduct.service.ProductServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImp(productRepository);
        Product product = Product.builder()
                .id(4L)
                .name("Test1")
                .price(100000.0)
                .stock(100.0)
                .category(Category.builder().id(1L).build())
                .build();
        Mockito.when(productRepository.findById(4L))
                .thenReturn(Optional.of(product));
    }

    @Test
    public void when_findById_return_product(){
        Product product = productService.findById(4L);
        Assertions.assertThat(product.getName()).isEqualTo("Test1");
    }

}
