//package lt.finalproject.eshop.services;
//
//import lt.finalproject.eshop.dto.Product;
//import lt.finalproject.eshop.repo.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ProductServiceImpl {
//
//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    private ProductRepository productRepository;
//
//
//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }
//
////    public List<Product> getProductByType(String type) {
//////        List<Product> product = repo.getByType(type);
////        return new List<Product> product;
////    }
//
//    public List<Product> getProductByManufacturer(String manufacturer) {
//        return productRepository.findByManufacturer(manufacturer);
//    }
//
//    public List<Product> getProductByModel(String model) {
//        return productRepository.findByModel(model);
//
//    }
//
//    public List<Product> getProductByPrice(int price) {
//        return productRepository.findByPrice(price);
//
//    }
//
//    public List<Product> getProductByQuantity(Double quantity) {
//        return productRepository.findByQuantity(quantity);
//    }
//
//    public double buy(Map<String, Double> cart) {
//        return cart.entrySet().stream()
//                .mapToDouble(pair -> buySingleProduct(pair.getKey(), pair.getValue()))
//                .sum();
//    }
//
//
//    private double buySingleProduct(Long id, int amount) {
//        Product productByName = productRepository.getOne(id);
//
//        if (productByName.isPresent()) {
//            Product product = productByName.get;
//            product.setQuantity((int) (product.getQuantity() - amount));
//            productRepository.save(product);
//        }
//        return productByName
//                .map(product -> product.getPrice() * amount)
//                .orElse(0.0);
//    }
//
//
//    Product one = productRepository.getOne()
//
//
//
////    public Double getBasketPrice(Map<String, Double> basket) {
//////        validateQuantities.checkIfEnoughProducts(basket);
////        Double total = 0d;
////        Double price;
////        for (Map.Entry<String, Double> entry : basket.entrySet()) {
////            price = getPrice(entry.getKey());
////            total += price * entry.getValue();
////        }
////        return total;
////    }
////
////    public Map<String, Double> buyProducts(Map<String, Double> basket) {
//////        validateQuantities.checkIfEnoughProducts(basket);
////        for (Map.Entry<String, Double> entry : basket.entrySet()) {
////            Double updatedQuantity = recalculateQuantity(entry.getKey(), entry.getValue());
////            entry.setValue(updatedQuantity);
////            repo.updateQuantityByModel(entry.getKey(), updatedQuantity);
////        }
////        return basket;
////    }
////
////
////    private Double recalculateQuantity(String model, double valueToBuy) {
////        Double stock = getQuantity(model);
////        double value = stock - valueToBuy;
////        return value;
////    }
//
//
//
//}
