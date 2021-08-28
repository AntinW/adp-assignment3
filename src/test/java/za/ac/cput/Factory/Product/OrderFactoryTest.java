/*
 *  Order.java
 *  Entity for for the Order
 *  Author: Abongile Tshopi (214254151)
 *  Date created: 08-06-2021
 */


package za.ac.cput.Factory.Product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Product.Order;
import za.ac.cput.Factory.Product.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;


class OrderFactoryTest {

    //The test passes as the method assertNotNull is true, the oder object is created successfully
    @Test
    public void createOrder0(){
        Order order = OrderFactory.createOrder("C123", "123Cake", "8-June-2021",
                "11-June-2021", "B527A, Site C", "Not deliverd", 60.00 );
        System.out.println(order);
       assertNotNull(order);
    }

    @Test
    public void disabling(){
        System.out.println("Temporal technical issues");
        disabling();

    }

    @Test
    public void failTest(){
        try{
            fail("Test is failing");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(true);
        }
    }

    //Time testing will pass as the time limit is 1 sec to generate the order that take 800 milli seconds
    @Test
    @Timeout(1)
        public void testTime() throws InterruptedException{

        Order oda = OrderFactory.createOrder("C123", "123Cake", "8-June-2021",
                "11-June-2021", "B527A, Site C", "Delivered", 60.00 );
        Thread.sleep(800);
        System.out.println(oda);


    }


    Order order1 = OrderFactory.createOrder("C123", "123Cake", "8-June-2021",
            "11-June-2021", "B527A, Site C", "Delivered", 60.00 );

    Order order0 = OrderFactory.createOrder("C123", "123Cake", "8-June-2021",
            "11-June-2021", "B527A, Site C", "Not deliverd", 120.00 );

    //The test will fail since order0 and order1 are not identical, each order have a unique oderID/s
    @Test
    public void testIdentity()
    {
        System.out.println(order0);
        System.out.println(order1);

        assertSame(order0, order1 );
    }

    //order0 and order1 are not equal, the test will fail
    @Test
    public void testingEquality(){
        System.out.println(order0);
        System.out.println(order1);

        assertEquals(order0, order1);


    }

}