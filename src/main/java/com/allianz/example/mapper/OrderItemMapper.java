package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.IBaseMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {

    @Autowired
    ProductMapper productMapper;
    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(entity.getId());
        orderItemDTO.setUuid(entity.getUuid());
        orderItemDTO.setCreationDate(entity.getCreationDate());
        orderItemDTO.setUpdatedDate(entity.getUpdatedDate());
        orderItemDTO.setProduct(productMapper.entityToDTO(entity.getProduct()));
        orderItemDTO.setQuantity(entity.getQuantity());
        orderItemDTO.setSellPrice(entity.getSellPrice());

        return orderItemDTO;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }

    @Override
    public List<OrderItemDTO> entityListToDTOList(List<OrderItemEntity> orderItemEntities) {
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        for (OrderItemEntity orderItemEntity : orderItemEntities) {
            orderItemDTOList.add(entityToDTO(orderItemEntity));
        }

        return orderItemDTOList;
    }

    @Override
    public List<OrderItemEntity> dtoListTOEntityList(List<OrderItemDTO> orderItemDTOS) {
        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            orderItemEntityList.add(dtoToEntity(orderItemDTO));
        }

        return orderItemEntityList;
    }

    @Override
    public OrderItemEntity requestDTOToEntity(OrderItemRequestDTO dto) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }

    public OrderItemEntity updateEntityFromRequestDTO(OrderItemEntity entity,OrderItemRequestDTO dto) {
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }
}