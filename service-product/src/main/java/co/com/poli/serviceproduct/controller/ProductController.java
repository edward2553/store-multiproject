package co.com.poli.serviceproduct.controller;

import co.com.poli.serviceproduct.entities.Product;
import co.com.poli.serviceproduct.helper.ResponseBuilder;
import co.com.poli.serviceproduct.model.Response;
import co.com.poli.serviceproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@RequestBody Product product){
        productService.save(product);
        return builder.success(product);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        if(product==null){
            return builder.failed("Not found product");
        }
        productService.delete(product);
        return builder.success(product);
    }

    @GetMapping
    public Response findAll(){
        List<Product> products = productService.findAll();
        if(products.isEmpty()){
            return builder.failed("Products is empty");
        }
        return builder.success(products);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        if(product==null){
            return builder.failed("Not found product");
        }
        return builder.success(product);
    }

}
