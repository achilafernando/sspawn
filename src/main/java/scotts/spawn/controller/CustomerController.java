package scotts.spawn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import scotts.spawn.entitiy.Customer;
import scotts.spawn.service.CustomerService;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/api/v1/customer/get";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);

    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public String saveCustomer(@RequestBody String body ) {
//
////        String  firstname=body.get("fisrtname");
////        String lastname=body.get("lastname");
//
//
//        return body;
////        return customerService.saveCustomer(new  Customer(body));
//
//    }


}
