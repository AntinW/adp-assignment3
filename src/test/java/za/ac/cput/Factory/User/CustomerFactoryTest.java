package za.ac.cput.Factory.User;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerFactoryTest class
 */



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.User.Customer;
import za.ac.cput.Factory.User.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private CustomerFactory cust1;
    private CustomerFactory cust2;
    private CustomerFactory cust3;

    @BeforeEach
    void setUp() {
        cust1 = new CustomerFactory();
        cust2 = new CustomerFactory();
        cust3 = cust1;
    }

    /*
     * Object Equality:
     * This test checks if the two objects are the same
     */
    @Test
    void testEquality() {
        assertEquals(cust1, cust3);
    }

    /*
     * Object Identity:
     * This test checks if the two objects are the same
     * This test will pass:
     */
    @Test
    void testIdentity() {
        assertSame(cust1, cust3);
    }
    //This test will fail:
    @Test
    void testIdentityFail() {
        assertSame(cust1, cust2);
    }

    /*
     * Timeout Test:
     * This test will fail after 5 seconds
     */
    //This test will pass:
    @Test
    @Timeout(5)
    void testTimeout() throws InterruptedException {
        Thread.sleep(4000);                         //Waits 5 seconds (5000 milliseconds)
        System.out.println("Passed!");
    }
    //This test will fail:
    @Test
    @Timeout(5)
    void testTimeoutFail() throws InterruptedException {
        Thread.sleep(6000);                         //Waits 5 seconds (5000 milliseconds)
        System.out.println("Passed!");
    }


    /*
     * Disabling test:
     * This test is disabled and will not run.
     */
    @Test
    @Disabled
    void DisabledTest() {
        assertEquals(10, 5+2+6);
    }


    //Test for CustomerFactory.build
    //This test is to check if the values are valid.
    //This test will pass
    @Test
    void validTest() {
        Customer c = CustomerFactory.build("Tye","Walker","0827482442","218338562@mycput.ac.za");
        System.out.println(c);
        assertNotNull(c);
    }

    //This test WILL fail because the email is invalid.
    @Test
    void valiTestFail() {
        Customer c = CustomerFactory.build("John","Doe","0123456789","John``Doe@gmail.com");
        System.out.println(c);
        assertNotNull(c);
    }
}