package com.amazonapi.amazonapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    private String name;
    private String description;
    private String category;
    private float price;
    private LocalDate creationDate;
    private String observations;
    private int quantity;

}
