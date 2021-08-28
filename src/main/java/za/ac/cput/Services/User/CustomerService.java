package za.ac.cput.Services.User;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Repository.User.CustomerRepository;
import za.ac.cput.Services.IService;

import java.util.Set;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

@Service
public class CustomerService implements ICustomerService {
    private static CustomerService customerService;
    private CustomerRepository customerRepository;

    private CustomerService() {
        this.customerRepository = CustomerRepository.getRepository();
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    // Create:
    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.create(customer);
    }

    // Read:
    @Override
    public Customer read(String c) {
        return this.customerRepository.read(c);
    }

    // Update:
    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.update(customer);
    }

    // Delete:
    @Override
    public void delete(String c) {
        this.customerRepository.delete(c);
    }

    // Get All:
    @Override
    public Set<Customer> getAll() {
        return this.customerRepository.getAll();
    }
}