package za.ac.cput.Entity.User;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  POJO for Customer entity
 */

public class Customer {
    private String custID;
    private String custFirstName, custLastName, custContact, custEmail;

    private Customer() {}

    private Customer(Builder builder) {
        this.custID = builder.custID;
        this.custFirstName = builder.custFirstName;
        this.custLastName = builder.custLastName;
        this.custContact = builder.custContact;
        this.custEmail = builder.custEmail;

    }

    public String getCustID() {
        return custID;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public String getCustContact() {
        return custContact;
    }

    public String getCustEmail() {
        return custEmail;
    }

    //Inner class
    public static class Builder {
        private String custID;
        private String custFirstName, custLastName, custContact, custEmail;


        public Builder custID(String custID) {
            this.custID = custID;
            return this;
        }

        public Builder custFirstName(String custFirstName) {
            this.custFirstName = custFirstName;
            return this;
        }

        public Builder custLastName(String custLastName) {
            this.custLastName = custLastName;
            return this;
        }

        public Builder custContact(String custContact) {
            this.custContact = custContact;
            return this;
        }

        public Builder custEmail(String custEmail) {
            this.custEmail = custEmail;
            return this;
        }

        public Customer builder() {
            return new Customer(this);

        }

        //Copy of Customer
        public Builder copy(Customer customer) {
            this.custID = customer.custID;
            this.custFirstName = customer.custFirstName;
            this.custLastName = customer.custLastName;
            this.custContact = customer.custContact;
            this.custEmail = customer.custEmail;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID=" + custID +
                ", custFirstName='" + custFirstName + '\'' +
                ", custLastName='" + custLastName + '\'' +
                ", custContact='" + custContact + '\'' +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }

}
