package za.ac.cput.Services.User;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Factory.User.CustomerFactory;
import static org.junit.jupiter.api.Assertions.*;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerServiceTest
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {
    private static CustomerService service = CustomerService.getCustomerService();
    private static Customer customer = CustomerFactory.build("John", "Wayne", "0829110073", "johnwayne@gmail.com");

    // Create Test:
    @Order(1)
    @Test
    void createTest() {
        Customer created = service.create(customer);
        assertEquals(created.getCustID(), customer.getCustID());
        System.out.println("Create: " + created);
    }

    // Read Test:
    @Order(2)
    @Test
    void readTest() {
        Customer read = service.read(customer.getCustID());
        assertEquals(read.getCustID(), customer.getCustID());
        System.out.println("Read: " + read);
    }

    // Update Test:
    // Email Changes
    @Order(3)
    @Test
    void updateTest() {
        Customer updateCustomer = new Customer.Builder().copy(customer).custEmail("johnwayne73@yahoo.com").builder();
        assertNotNull(service.update(updateCustomer));
        System.out.println("Update: " + updateCustomer);
    }

    // Delete Test:
    @Order(4)
    @Test
    void deleteTest() {
        service.delete(customer.getCustID());
        assertNotNull(service);
        System.out.println("Deleted.");
    }


}