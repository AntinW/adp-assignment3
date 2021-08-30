package za.ac.cput.Controller.Product;
/*
* Author Robyn White - 218034555
*Supplier Controller Test
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Product.Supplier;
import za.ac.cput.Factory.Product.SupplierFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplierControllerTest {
    private static Supplier s = SupplierFactory.build("Nissan","Nissan@gmail","123456");

    @Autowired
    private TestRestTemplate restTemp;
    private final String BASE_URL= "http://localhost:8080/supplier";



    @Test
    void A_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Supplier> response = restTemp.postForEntity(url, s, Supplier.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        s = response.getBody();
        System.out.println("Supplier created: " + s);
        assertEquals(s.getSupplierID(), response.getBody().getSupplierID());
    }


    @Test
    void B_read() {
        String url = BASE_URL + "/read/" + s.getSupplierID();
        System.out.println("URL: " + url);
        ResponseEntity<Supplier> response = restTemp.getForEntity(url, Supplier.class);
        assertEquals(s.getSupplierID(), response.getBody().getSupplierID());
    }


    @Test
    void C_update() {
        Supplier updated = new Supplier.Builder().copy(s).setSupplierEmail("Japan@gmail").build();
        String url = BASE_URL + "/update";
        System.out.println("Updated Supplier Info: " + updated);
        ResponseEntity<Supplier> response = restTemp.postForEntity(url, s, Supplier.class);
        assertNotNull(response.getBody());
    }


    @Order(5)
    @Test
    void E_delete() {
        String url = BASE_URL + "/delete/" + s.getSupplierID();
        restTemp.delete(url);
    }


    @Order(4)
    @Test
    void D_getAllTest() {
        String url = BASE_URL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemp.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("All Suppliers: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}