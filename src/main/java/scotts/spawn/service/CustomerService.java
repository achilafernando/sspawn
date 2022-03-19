package scotts.spawn.service;

import scotts.spawn.entitiy.Customer;

import java.util.List;

public interface  CustomerService {

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);
}
