package com.allianz.example.service;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService {

    private final OrderItemEntityRepository orderItemEntityRepository;

    private final OrderItemMapper orderItemMapper;

    public OrderItemService(OrderItemEntityRepository orderItemEntityRepository, OrderItemMapper orderItemMapper) {
        this.orderItemEntityRepository = orderItemEntityRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderItemDTO save(OrderItemRequestDTO dto) {
        OrderItemEntity orderItemEntity = orderItemMapper.requestDTOToEntity(dto);
        orderItemEntityRepository.save(orderItemEntity);
        return orderItemMapper.entityToDTO(orderItemEntity);
    }


    public List<OrderItemDTO> getAll() {
        List<OrderItemEntity> orderItemEntityList = orderItemEntityRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntityList);
    }



    public OrderItemDTO update(UUID uuid, OrderItemRequestDTO dto) {
        Optional<OrderItemEntity> existingOrderItemEntity = orderItemEntityRepository.findByUuid(uuid);
        if(existingOrderItemEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen orderItem bulunamadı!");
        }
        OrderItemEntity updatedEntity = orderItemMapper.updateEntityFromRequestDTO(existingOrderItemEntity.get(), dto);
        orderItemEntityRepository.save(updatedEntity);
        return orderItemMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<OrderItemEntity> existingOrderItemEntity = orderItemEntityRepository.findByUuid(uuid);

        if(existingOrderItemEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen orderItem bulunamadı!");
        }
        orderItemEntityRepository.delete(existingOrderItemEntity.get());
    }

    public OrderItemDTO getByUuid(UUID uuid) {
        Optional<OrderItemEntity> foundOrderItemEntity = orderItemEntityRepository.findByUuid(uuid);

        if(foundOrderItemEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen orderItem bulunamadı!");
        }
        return orderItemMapper.entityToDTO(foundOrderItemEntity.get());
    }
}
