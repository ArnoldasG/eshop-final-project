package lt.finalproject.eshop;

import lt.finalproject.eshop.dto.User;
import lt.finalproject.eshop.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class EshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }


    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("Arnoldas", "Domilė", "Titas", "Artūr", "Deividasl").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@eshop.lt");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}





