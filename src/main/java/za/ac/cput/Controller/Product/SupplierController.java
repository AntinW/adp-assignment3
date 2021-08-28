package za.ac.cput.Controller.Product;

/*
 * Author Robyn White - 218034555
 *Supplier controller
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Product.Supplier;
import za.ac.cput.Factory.Product.SupplierFactory;
import za.ac.cput.Services.Product.SupplierService;

import java.util.Set;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @PostMapping("/Create")
    public Supplier create(@RequestBody Supplier supplier)
    {
        Supplier newSupplier =  SupplierFactory.build(supplier.getSupplierName(),supplier.getSupplierEmail(),
                supplier.getSupplierPhone());
        return supplierService.create(newSupplier);
    }


    @GetMapping("/read/{id}")
    public Supplier read(@PathVariable String id) {
        return supplierService.read(id);
    }


    @PostMapping("/update")
    public Supplier update(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        supplierService.delete(id);
    }



    @GetMapping("/getall")
    public Set<Supplier> getAll() {
        return supplierService.getAll();
    }

}
