/* ProductFactoryTest.java
class to test validity of input provided
Author: Antin Williams 219212058
Date: 09 June 2021
 */
package za.ac.cput.Factory.Product;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Product.Product;
import za.ac.cput.Factory.Product.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

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