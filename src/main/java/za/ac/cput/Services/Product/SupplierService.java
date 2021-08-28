package za.ac.cput.Services.Product;
/*
 * Author: Robin White - 218034555
 * Supplier Service
 * 25 July 2021
 */
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Product.Supplier;
import za.ac.cput.Repository.Product.SupplierRepository;
import za.ac.cput.Services.IService;

import java.util.Set;

@Service
public class SupplierService implements ISupplierService  {

    private static SupplierService service;
    private SupplierRepository repository;

    private SupplierService()
    {
        this.repository = SupplierRepository.getRepository();
    }

    public static SupplierService getService()
    {
        if(service == null)
        {
            service = new SupplierService();
        }
        return service;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.repository.create(supplier);
    }

    @Override
    public Supplier read(String s) {
        return this.repository.read(s);
    }


    @Override
    public Supplier update(Supplier supplier) {
        return this.repository.update(supplier);
    }


    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }


    @Override
    public Set<Supplier> getAll() {
        return this.repository.getAll();
    }
}
