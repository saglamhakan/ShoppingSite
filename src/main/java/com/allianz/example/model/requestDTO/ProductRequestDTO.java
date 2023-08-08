package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductRequestDTO extends BaseDTO {

    private String name;

    private String code;

    private ColorEnum color;

    private BigDecimal sellPrice;

    private BigDecimal buyPrice;

    private Integer quantity;

    private Set<CategoryEntity> categoryList;

    private TaxEntity tax;
}
