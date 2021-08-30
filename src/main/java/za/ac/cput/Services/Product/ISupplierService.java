package za.ac.cput.Services.Product;
/*
 * Author Robyn White - 218034555
 * ISupplierService
 */
import za.ac.cput.Entity.Product.Supplier;
import za.ac.cput.Services.IService;

import java.util.Set;

public interface ISupplierService  extends IService<Supplier, String> {
    public Set<Supplier> getAll();
}
