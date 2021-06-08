/*
 *  Order.java
 *  Entity for for the Order
 *  Author: Abongile Tshopi (214254151)
 *  Date created: 08-06-2021
 */

package za.ac.cput.ADPAssignment3.Entity;

import java.util.Locale;

public class Order {

    private  String custID, productID, orderDate, orderShippedDate, orderAddress, orderStatus;
    private double orderTotal;

    private Order(Builder builder) {
        this.custID = builder.custID;
        this.productID = builder.productID;
        this.orderDate = builder.orderDate;
        this.orderShippedDate = builder.orderShippedDate;
        this.orderAddress = builder.orderAddress;
        this.orderStatus = builder.orderStatus;
        this.orderTotal = builder.orderTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "custID='" + custID + '\'' +
                ", productID='" + productID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderShippedDate='" + orderShippedDate + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTotal=" + orderTotal +
                '}';
    }

    public static class Builder{
        private String custID, productID, orderDate, orderShippedDate, orderAddress, orderStatus;
        private double orderTotal;

        public Builder setCustID(String custID) {
            this.custID = custID;
            return this;
        }

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderShippedDate(String orderShippedDate) {
            this.orderShippedDate = orderShippedDate;
            return this;
        }

        public Builder setOrderAddress(String orderAddress) {
            this.orderAddress = orderAddress;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setOrderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Order build(){

            return new Order(this);
        }



        public Builder copy(Order order){
            this.custID = order.custID;
            this.productID = order.productID;
            this.orderDate = order.orderDate;
            this.orderShippedDate = order.orderShippedDate;
            this.orderAddress = order.orderAddress;
            this.orderStatus = order.orderStatus;
            this.orderTotal = order.orderTotal;
            return this;
        }
    }

}
