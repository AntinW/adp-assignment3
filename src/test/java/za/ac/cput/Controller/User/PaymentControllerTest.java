/* PaymentControllerTest.java
 Entity for Payment Controller Test
 Author: Cameron van Wyk (219088470)
 Date: 17 August 2021
*/

package za.ac.cput.Controller.User;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.User.Payment;
import za.ac.cput.Factory.User.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest
{
    private static Payment payment = PaymentFactory.createPayment("12/02/2020" , "Payment", 20.00);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/payment";

    @Test
    void a_create()
    {
        String url = baseURL + "/Create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);

        payment = postResponse.getBody();

        System.out.println("Saved Data:" + payment);
        assertEquals(payment.getCustomerID(), postResponse.getBody().getCustomerID());
    }

    @Test
    void b_read()
    {
        String url = baseURL + "/Read/" + payment.getCustomerID();

        System.out.println("Url: " + url);
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        assertEquals(payment.getCustomerID(), response.getBody().getCustomerID());
    }

    @Test
    void c_update()
    {
        Payment updated = new Payment.Builder().copy(payment).setPaymentTotal(145).build();

        String url = baseURL + "/Update";
        System.out.println("Url: " + url);
        System.out.println("Post Data: " + updated);

        ResponseEntity<Payment> response = restTemplate.postForEntity(url, updated, Payment.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = baseURL + "/Delete/" + payment.getCustomerID();
        System.out.println("Url: " + url);
        restTemplate.delete(url);
    }
}