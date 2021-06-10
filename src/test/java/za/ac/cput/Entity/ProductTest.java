/* ProductTest.java
class to test validity of input provided
Author: Antin Williams 219212058
Date: 09 June 2021
 */
package za.ac.cput.Entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testInvalidData(){
        Product product = ProductFactory.build("", -23);
        System.out.println(product);
        assertNull(product);
    }

    @Test
    void testValidData(){
        Product product = ProductFactory.build("Cupcake", 32);
        System.out.println(product);
        assertNotNull(product);
    }
}