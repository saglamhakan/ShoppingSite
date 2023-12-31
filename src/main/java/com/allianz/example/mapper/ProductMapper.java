package com.allianz.example.mapper;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {

    @Autowired
    @Lazy
    TaxMapper taxMapper;

    @Autowired
    @Lazy
    CategoryMapper categoryMapper;

    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(entity.getId());
        productDTO.setUuid(entity.getUuid());
        productDTO.setName(entity.getName());
        productDTO.setCode(entity.getCode());
        productDTO.setColor(entity.getColor());
        productDTO.setCreationDate(entity.getCreationDate());
        productDTO.setUpdatedDate(entity.getUpdatedDate());
        productDTO.setTax(taxMapper.entityToDTO(entity.getTax()));
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setBuyPrice(entity.getBuyPrice());
        productDTO.setSellPrice(entity.getSellPrice());

        return productDTO;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setColor(dto.getColor());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTax(taxMapper.dtoToEntity(dto.getTax()));
        entity.setQuantity(dto.getQuantity());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {
            productDTOS.add(entityToDTO(productEntity));
        }

        return productDTOS;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> productEntityList = new ArrayList<>();

        for (ProductDTO productDTO : productDTOS) {
            productEntityList.add(dtoToEntity(productDTO));
        }

        return productEntityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {

        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setColor(dto.getColor());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTax(dto.getTax());
        entity.setQuantity(dto.getQuantity());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setSellPrice(dto.getSellPrice());
        entity.setCategoryList(dto.getCategoryList());

        return entity;
    }

    public ProductEntity updateEntityFromRequestDTO(ProductEntity entity, ProductRequestDTO dto) {


        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setColor(dto.getColor());
        entity.setTax(dto.getTax());
        entity.setQuantity(dto.getQuantity());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setSellPrice(dto.getSellPrice());
        entity.setCategoryList(dto.getCategoryList());

        return entity;
    }

    public Set<ProductDTO> entitiesToDTOs(Set<ProductEntity> entities) {
        return entities.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toSet());
    }

    public Set<ProductEntity> dtosToEntities(Set<ProductDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toSet());
    }


}