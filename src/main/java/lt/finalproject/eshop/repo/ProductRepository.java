package lt.finalproject.eshop.repo;

import lt.finalproject.eshop.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    Optional<Product> findById(Long Id); // impl nereikia, nes JPA jį turi

    //List<Product> findAll();  Sitas metodas jau yra JpaRepository

    List<Product> findByManufacturer(String type);

    List<Product> findByModel(String model);

    List<Product> findByPrice(Double price);

    List<Product> findByQuantity(int quantity);

//    @Transactional
//    @Modifying(flushAutomatically = true, clearAutomatically = true)
//    @Query ("update Stock s set s.stock = :stock where s.productType = :productType")
//    void updateStock(@Param("stock") Double stock, @Param("productType") ProductType productType);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query ("SELECT price FROM Product p WHERE p.id = :id")
    Double findPriceByID(@Param("id") Long id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query ("SELECT quantity FROM Product p WHERE p.id = :id")
    Integer findQuantityById(@Param("id") Long id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query ("UPDATE Product p SET p.quantity = :quantity WHERE p.id = :id")
    Integer updateQuantityById(@Param("quantity") Integer quantity, @Param("id") Long id);

}
