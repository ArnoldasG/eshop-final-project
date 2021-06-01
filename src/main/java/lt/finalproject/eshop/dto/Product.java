package lt.finalproject.eshop.dto;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated (EnumType.STRING)
        @Column(name = "product_type")
        private ProductType productType;

        private String manufacturer;
        private String model;
        private Double price;
        private String image;
        private String description;
        private int quantity;
}
