package lt.finalproject.eshop.services;

import lt.finalproject.eshop.dto.Product;

import java.util.List;

public interface ProductService {


    List<Product> findByManufacturer(String type);

    List<Product> findByModel(String model);

    List<Product> findByPrice(Double price);

    List<Product> findByQuantity(int quantity);

    Double findPriceByID(Long id);

    Integer findQuantityById(Long id);

}
