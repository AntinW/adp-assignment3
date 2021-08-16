/* PaymentController.java
 Entity for Payment Controller
 Author: Cameron van Wyk (219088470)
 Date: 16 August 2021
*/

package za.ac.cput.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.User.Payment;
import za.ac.cput.Factory.User.PaymentFactory;
import za.ac.cput.Services.User.PaymentService;

import java.util.Set;

@RestController
@RequestMapping("/Payment")
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/Create")
    public Payment create(@RequestBody Payment payment)
    {
        Payment newPayment =  PaymentFactory.createPayment("2021/06/02" , "Payment", 1000);
        return paymentService.create(newPayment);
    }

    @GetMapping("/Read")
    public Payment read(@RequestBody Payment payment)
    {
        return paymentService.read(payment.getCustomerID());
    }

    @PostMapping("/Update")
    public Payment update(@RequestBody Payment payment)
    {
        return paymentService.update(payment);
    }

    @PostMapping("/Delete")
    public void delete(@RequestBody Payment payment)
    {
        paymentService.delete(payment.getCustomerID());
    }

    @GetMapping("/getAll")
    public Set<Payment> getAll()
    {
        return paymentService.getAll();
    }

}
