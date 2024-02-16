package com.ecommerce.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double amount;
    private String imageUrl;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    // Getters and setters
}
