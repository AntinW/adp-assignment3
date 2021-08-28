/* PaymentFactory.java
 Entity for Payment Factory
 Author: Cameron van Wyk (219088470)
 Date: 09 June 2021
*/

package za.ac.cput.Factory.User;

import za.ac.cput.Entity.User.Payment;
import za.ac.cput.util.GenericHelper;

public class PaymentFactory
{
    public static Payment createPayment(String paymentDate, String paymentDetails, double paymentTotal)
    {
        String customerID = GenericHelper.generateId();
        Payment payment = new Payment.Builder().setCustomerID(customerID)
                .setPaymentDate(paymentDate)
                .setPaymentDetails(paymentDetails)
                .setPaymentTotal(paymentTotal).build();

        return payment;
    }
}