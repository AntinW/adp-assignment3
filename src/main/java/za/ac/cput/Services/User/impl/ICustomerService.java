package za.ac.cput.Services.User.impl;

import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Repository.User.CustomerRepository;
import za.ac.cput.Services.User.CustomerService;

public class ICustomerService implements CustomerService {
    private static CustomerService customerService;
    private CustomerRepository customerRepository;

    private ICustomerService() {
        this.customerRepository = CustomerRepository.getRepository();
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new ICustomerService();
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
}
