package lt.finalproject.eshop.controllers;

import lt.finalproject.eshop.dto.Product;
import lt.finalproject.eshop.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/products")
@Component
public class ProductController {

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    private ProductServiceImpl productServiceImpl;

    @GetMapping
    public List<Product> getAllProductProducts() {
        return productServiceImpl.findAll();
    }

//    @GetMapping("/{type}")
//    public List<Product> getProductByType(@PathVariable String type) {
//        return productService.getProductByType(type);
//    }

    @GetMapping("/{manufacturer}")
    public List<Product> getProductByManufacturer(@PathVariable String manufacturer) {
        return productServiceImpl.findByManufacturer(manufacturer);
    }

    @GetMapping("/{model}")
    public List<Product> getProductByModel(@PathVariable String model) {
        return productServiceImpl.findByModel(model);
    }

    @GetMapping("/{price}")
    public List<Product> getProductByPrice(@PathVariable Double price) {
        return productServiceImpl.findByPrice(price);
    }

    @GetMapping(value = "/{quantity}")
    public List<Product> getProductByQuantity(@PathVariable Integer quantity) {
        return productServiceImpl.findByQuantity(quantity);
    }

    @PostMapping(value = "/cart")
    public void buyProducts(@ModelAttribute Map<Long, Integer> basket) {
        productServiceImpl.buy(basket);
    }


}
