package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO extends BaseDTO {

    private ProductEntity product;

    private Integer quantity;

    private BigDecimal sellPrice;

}
