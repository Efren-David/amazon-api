package com.amazonapi.amazonapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductPatchDTO {

    private String field;
    private String value;
}
