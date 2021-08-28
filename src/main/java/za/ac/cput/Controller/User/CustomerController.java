package za.ac.cput.Controller.User;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerController.java
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Factory.User.CustomerFactory;
import za.ac.cput.Services.User.CustomerService;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create:
    // @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        Customer newCustomer = CustomerFactory.build(customer.getCustFirstName(), customer.getCustLastName(),
                                                    customer.getCustContact(), customer.getCustEmail());
        return customerService.create(newCustomer);
    }

    // Read:
    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id) {
        return customerService.read(id);
    }

    // Update:
    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    // Delete: (chage to boolean)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }


    // Get All:
    @GetMapping("/getall")
    public Set<Customer> getAll() {
        return customerService.getAll();
    }
}
