package com.amazonapi.amazonapi.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderOutDto {

    private Long id;
    private LocalDate date;
    private int quantity;
    private ProductDto product;
}
