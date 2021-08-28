package za.ac.cput.Factory.Product;

/* SupplierFactoryTest.java
Factory Test for Supplier
Author: Robyn White  (218034555)
Date: 09 June 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Product.Supplier;
import za.ac.cput.Factory.Product.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;


public class SupplierFactoryTest {

    @Test                                                           //Tests to see if all fields have a value and is not null
    void testCorrectData(){
        Supplier s = SupplierFactory.build("CakeHouse","Cakeman@gmail.com","0216549132");
        System.out.println(s);
        assertNotNull(s);
    }

    @Test                                                           //Tests to see if all fields are null, returns null
    void testIncorrectData(){
        Supplier s = SupplierFactory.build("","","");
        System.out.println(s);
        assertNull(s);
    }

    @Test                                                           //Tests equality
    void testEquality(){

        Supplier s = SupplierFactory.build("CakeHouse","Cakeman@gmail.com","0216549132");
        assertEquals(s,s);
    }

    @Test                                                           //Test Identity
    void testIdentity(){
        Supplier s = SupplierFactory.build("CakeHouse","Cakeman@gmail.com","0216549132");
        assertSame(s,s);
    }

    @Test                                                           //Waits 5 seconds before test timeout
    @Timeout(10)
    void testTimeout() throws InterruptedException {
            Thread.sleep(5000);
            System.out.println("Test timeout");
    }

    @Disabled("Test has been Disabled")                             //Disables Test
    @Test
    void test() {
        assertEquals(2, 1 + 1);
    }
}
