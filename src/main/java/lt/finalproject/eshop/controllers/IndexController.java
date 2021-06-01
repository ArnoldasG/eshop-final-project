package lt.finalproject.eshop.controllers;

import lt.finalproject.eshop.dto.Product;
import lt.finalproject.eshop.dto.UserRegistration;
import lt.finalproject.eshop.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {

    private final ProductRepository productRepository;

    public IndexController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping({"/index"})
//    public String index() {
//
//        return "index";
//    }
//
//    @GetMapping("/register")
//    public String showSignUpForm(Model model) {
//        model.addAttribute("user", new UserRegistration());
//
//        return "signup_form";
//    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping("/product")
    void addProduct (@RequestBody Product product) {
        productRepository.save(product);
    }
}
