package com.allianz.example.model;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO extends BaseDTO {

    private ProductDTO product;

    private Integer quantity;

    private BigDecimal sellPrice;
}
