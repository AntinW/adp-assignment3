package za.ac.cput.Entity.Product;

/* SupplierEntity.java
Entity for Supplier
Author: Robyn White  (218034555)
Date: 04 June 2021
 */

public class Supplier {

    private String supplierID, productID, supplierName, supplierEmail, supplierPhone;

    public Supplier(String supplierID, String productID, String supplierName, String supplierEmail, String supplierPhone) {
        this.supplierID = supplierID;
        this.productID = productID;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    private Supplier(Builder builder)
    {
        this.supplierID = builder.supplierID;
        this.productID = builder.productID;
        this.supplierName = builder.supplierName;
        this.supplierEmail = builder.supplierEmail;
        this.supplierPhone = builder.supplierPhone;

    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getProductID() {
        return productID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }


    public static class Builder {

        private String supplierID, productID, supplierName, supplierEmail, supplierPhone;


        public Builder setSupplierID(String supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder setSupplierEmail(String supplierEmail) {
            this.supplierEmail = supplierEmail;
            return this;
        }

        public Builder setSupplierPhone(String supplierPhone) {
            this.supplierPhone = supplierPhone;
            return this;
        }


        public Supplier build(){

            return new Supplier(this);
        }

        public Builder copy(Supplier s){
            this.supplierID = s.supplierID;
            this.productID = s.productID;
            this.supplierName = s.supplierName;
            this.supplierEmail = s.supplierEmail;
            this.supplierPhone = s.supplierPhone;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", productID=" + productID +
                ", supplierName='" + supplierName + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                '}';
    }

}
