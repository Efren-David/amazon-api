package com.amazonapi.amazonapi.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInDto {

    private int quantity;
    private Long productId;
}
