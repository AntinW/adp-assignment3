/* Payment.java
 Entity for Payment
 Author: Cameron van Wyk (219088470)
 Date: 06 June 2021
*/

package za.ac.cput.Entity.User;

public class Payment
{
    private static String customerID;
    private String paymentDate, paymentDetails;
    private double paymentTotal;

    public Payment()
    {
        
    }

    private Payment(Builder builder)
    {
        this.customerID = builder.customerID;
        this.paymentDate = builder.paymentDate;
        this.paymentDetails = builder.paymentDetails;
        this.paymentTotal = builder.paymentTotal;
    }

    public static String getCustomerID()
    {
        return customerID;
    }

    @Override
    public String toString()
    {
        return "Payment{" +
                "customerID=" + customerID +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                ", paymentTotal=" + paymentTotal +
                '}';
    }

    public static class Builder
    {
        private String customerID;
        private String paymentDate, paymentDetails;
        private double paymentTotal;

        public Builder setCustomerID(String customerID)
        {
            this.customerID = customerID;
            return this;
        }

        public Builder setPaymentDate(String paymentDate)
        {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentDetails(String paymentDetails)
        {
            this.paymentDetails = paymentDetails;
            return this;
        }

        public Builder setPaymentTotal(double paymentTotal)
        {
            this.paymentTotal = paymentTotal;
            return this;
        }

        public Payment build()
        {
            return new Payment(this);
        }

        public Builder copy(Payment payment)
        {
            this.customerID = payment.customerID;
            this.paymentDate = payment.paymentDate;
            this.paymentDetails = payment.paymentDetails;
            this.paymentTotal = payment.paymentTotal;

            return this;
        }
    }
}
