package za.ac.cput.Services.User;

import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Repository.User.CustomerRepository;
import za.ac.cput.Services.IService;

import java.util.Set;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  ICustomerService
 */

public interface ICustomerService extends IService<Customer, String> {
    public Set<Customer> getAll();
}
