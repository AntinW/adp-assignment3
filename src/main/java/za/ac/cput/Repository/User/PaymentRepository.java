/* Payment.java
 Entity for Payment Repository
 Author: Cameron van Wyk (219088470)
 Date: 23 July 2021
*/

package za.ac.cput.Repository.User;

import za.ac.cput.Entity.User.Payment;
import za.ac.cput.Factory.User.PaymentFactory;
import za.ac.cput.Repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class PaymentRepository implements IRepository<Payment, String>
{
    private Set<Payment> paymentDescription;

    public PaymentRepository()
    {
        this.paymentDescription = new HashSet<>();
    }

    @Override
    public Payment create(Payment payment)
    {
        payment = PaymentFactory.createPayment("2021/06/02" , "Payment", 1000);
        this.paymentDescription.add(payment);
        return payment;
    }

    @Override
    public Payment read(String customerID)
    {
        Payment payment = null;
        for(Payment p: paymentDescription)
        {
            if(p.getCustomerID().equalsIgnoreCase(customerID))
            {
                payment = p;
                break;
            }
        }
        return payment;
    }

    @Override
    public Payment update(Payment payment)
    {
        Payment oldPayment = read(Payment.getCustomerID());
        if(oldPayment != null)
        {
            paymentDescription.remove(oldPayment);
            paymentDescription.add(payment);
        }
        return payment;
    }

    @Override
    public void delete(String customerID)
    {
        Payment payment = read(customerID);

        if(customerID != null)
        {
            this.paymentDescription.remove(payment);
        }
    }
}
