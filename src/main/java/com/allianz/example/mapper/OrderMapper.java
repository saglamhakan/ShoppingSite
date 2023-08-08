package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(entity.getId());
        orderDTO.setUuid(entity.getUuid());
        orderDTO.setCreationDate(entity.getCreationDate());
        orderDTO.setUpdatedDate(entity.getUpdatedDate());
        orderDTO.setOrderStatus(entity.getOrderStatus());
        orderDTO.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));
        orderDTO.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        orderDTO.setTotalSellPrice(entity.getTotalSellPrice());
        return orderDTO;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setTotalSellPrice(dto.getTotalSellPrice());

        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntities) {
            orderDTOList.add(entityToDTO(orderEntity));
        }

        return orderDTOList;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        List<OrderEntity> orderEntities = new ArrayList<>();

        for (OrderDTO orderDTO : orderDTOS) {
            orderEntities.add(dtoToEntity(orderDTO));
        }

        return orderEntities;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setTotalSellPrice(dto.getTotalSellPrice());


        return entity;
    }

    public OrderEntity updateEntityFromRequestDTO(OrderEntity entity, OrderRequestDTO dto) {

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setTotalSellPrice(dto.getTotalSellPrice());

        return entity;
    }


}