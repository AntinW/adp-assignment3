package za.ac.cput.Controller.User;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  Customer Controller Test
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Factory.User.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // Defined port so it uses to 8080
public class CustomerControllerTest {
    private static Customer customer = CustomerFactory.build("John", "Doe", "0821234567", "johndoe@gmail.com");
    private static Customer customerTwo = CustomerFactory.build("Jane", "Hey", "0827654321", "JaneHey@gmail.com");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customer";

    // Create Test
    @Order(1)
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        customer = postResponse.getBody();
        System.out.println("Customer Saved: " + customer);
        assertEquals(customer.getCustID(), postResponse.getBody().getCustID());
    }

    // Create Test 2
    @Order(2)
    @Test
    void createTwo() {
        String url = baseURL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customerTwo, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        customerTwo = postResponse.getBody();
        System.out.println("Customer Saved: " + customerTwo);
        assertEquals(customerTwo.getCustID(), postResponse.getBody().getCustID());
    }

    // Read Test
    @Order(3)
    @Test
    void read() {
        String url = baseURL + "/read/" + customer.getCustID();
        System.out.println("URL: " + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(customer.getCustID(), response.getBody().getCustID());
    }

    // Update Test
    @Order(4)
    @Test
    void update() {
        Customer customerUpdated = new Customer.Builder().copy(customer).custLastName("Dig").builder();
        String url = baseURL + "/update";
        System.out.println("Updated Customer: " + customerUpdated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, customerUpdated, Customer.class);
        assertNotNull(response.getBody());
    }

    // Delete Test
    @Order(5)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + customer.getCustID();
        restTemplate.delete(url);
    }

    // Get All Test
    @Order(6)
    @Test
    void getAllTest() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Customers): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

}