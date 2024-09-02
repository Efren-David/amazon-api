package com.amazonapi.amazonapi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String category;

    private float price;

    @Column(name = "creation_date")
    private LocalDate createDate;

    private String observations;

    private int quantity;

    @OneToMany(mappedBy = "product")
    @JsonBackReference(value = "product-orders")
    private List<Order> orders;




}
