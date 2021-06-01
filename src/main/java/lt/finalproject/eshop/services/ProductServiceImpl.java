package lt.finalproject.eshop.services;

import lt.finalproject.eshop.dto.Product;
import lt.finalproject.eshop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.Pair.toMap;

@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByManufacturer(String manufacturer) {
        return productRepository.findByManufacturer(manufacturer);
    }

    @Override
    public List<Product> findByModel(String model) {
        return productRepository.findByModel(model);
    }

    @Override
    public List<Product> findByPrice(Double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findByQuantity(int quantity) {
        return findByQuantity(quantity);
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }



    @Override
    public Double findPriceByID(Long id) {
        return productRepository.getOne(id).getPrice();
    }

    @Override
    public Integer findQuantityById(Long id) {
        return productRepository.getOne(id).getQuantity();
    }

    public void buy(Map<Long, Integer> basket){
        getBasketPrice(basket);
        updateQuantities(basket);
    }


    public Double getBasketPrice(Map<Long, Integer> basket) {
//        validateQuantities.checkIfEnoughProducts(basket);
        Double total = 0d;
        Double price;
        for (Map.Entry<Long, Integer> entry : basket.entrySet()) {
//             price = findPriceByID(entry.getKey());
            // Jinai nereikalinga, nes kaina gaunama iškarto iš HashMap
            price = productRepository.getOne(entry.getKey()).getPrice();
            total += price * entry.getValue();
        }
        return total;
    }

    public Map<Long, Integer> updateQuantities(Map<Long, Integer> basket) {
//        validateQuantities.checkIfEnoughProducts(basket);
        basket.entrySet().stream()
                .forEach(pair -> extractStock(pair.getKey(), pair.getValue()));
        return basket;
    }

    private void extractStock(Long id, Integer quantityToBuy) {
        productRepository.reduceRemainingQuantity(quantityToBuy, id);
    }

}


