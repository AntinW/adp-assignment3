/* PaymentRepositoryTest.java
 Entity for Payment Repository Test
 Author: Cameron van Wyk (219088470)
 Date: 23 July 2021
*/

package za.ac.cput.Repository.User;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.User.Payment;
import za.ac.cput.Factory.User.PaymentFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest
{
    private static PaymentRepository paymentRepository = new PaymentRepository();
    private Payment payment = PaymentFactory.createPayment("2021/06/02" , "Payment", 1000);

    @Test
    void create()
    {
        Payment created = paymentRepository.create(payment);
        assertEquals(payment.getCustomerID(), created.getCustomerID());
        System.out.println("Created: " + created);
    }

    @Test
    void read()
    {
        Payment read = paymentRepository.read(payment.getCustomerID());
        System.out.println("Read: " + read);
    }

    @Test
    void update()
    {
        Payment updated = new Payment.Builder().copy(payment).setCustomerID("11").build();
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete()
    {
        paymentRepository.delete(payment.getCustomerID());
        System.out.println("Deleted: " + payment.getCustomerID() + "");
    }
}