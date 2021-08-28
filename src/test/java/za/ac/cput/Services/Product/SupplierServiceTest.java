package za.ac.cput.Services.Product;
/*
 * Author: Robin White - 218034555
 * Test for Supplier Repository
 * 25 July 2021
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Product.Supplier;
import za.ac.cput.Factory.Product.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;
 @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceTest {
   private static SupplierService service = SupplierService.getService();
   private static Supplier supplier = SupplierFactory.build("Lays","Lays@gmail.com","021785468");

     @Order(1)
     @Test
     void create() {
         Supplier create = service.create(supplier);
         assertEquals(create.getSupplierID(),supplier.getSupplierID());
         System.out.println("Create: " + create);
     }
     @Order(2)
    @Test
    void read() {
        Supplier read = service.read(supplier.getSupplierID());
        assertEquals(read.getSupplierID(),supplier.getSupplierID());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void update() {
        Supplier updated = new Supplier.Builder().copy(supplier).setSupplierName("Simba").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Order(4)
    @Test
    void delete() {
        service.delete(supplier.getSupplierID());
        assertNotNull(service);
        System.out.println("Supplier has been Deleted");
    }


 }