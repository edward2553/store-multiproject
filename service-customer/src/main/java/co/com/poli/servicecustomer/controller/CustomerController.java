package co.com.poli.servicecustomer.controller;

import co.com.poli.servicecustomer.entities.Customer;
import co.com.poli.servicecustomer.helper.ResponseBuilder;
import co.com.poli.servicecustomer.model.Response;
import co.com.poli.servicecustomer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@RequestBody Customer customer){
        customerService.save(customer);
        return builder.success(customer);
    }
    @DeleteMapping("/{numberID}")
    public Response delete(@PathVariable("numberID") String numberID){
        Customer customer = (Customer) findByNumberID(numberID).getData();
        if(customer==null){
            return builder.failed("Not found");
        }
        return builder.success(customer);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(customerService.findAll());
    }

    @GetMapping("/numberID/{numberID}")
    public Response findByNumberID(@PathVariable("numberID") String numberID){
        return builder.success(customerService.findByNumberID(numberID));
    }

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(customerService.findById(id));
    }

    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }

}
