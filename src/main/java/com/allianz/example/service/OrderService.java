package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderEntityRepository orderEntityRepository;

    private final OrderMapper orderMapper;

    public OrderService(OrderEntityRepository orderEntityRepository, OrderMapper orderMapper) {
        this.orderEntityRepository = orderEntityRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDTO save(OrderRequestDTO dto) {
        OrderEntity orderEntity = orderMapper.requestDTOToEntity(dto);
        orderEntityRepository.save(orderEntity);
        return orderMapper.entityToDTO(orderEntity);
    }


    public List<OrderDTO> getAll() {
        List<OrderEntity> orderEntityList = orderEntityRepository.findAll();
        return orderMapper.entityListToDTOList(orderEntityList);
    }



    public OrderDTO update(UUID uuid, OrderRequestDTO dto) {
        Optional<OrderEntity> existingOrderEntity = orderEntityRepository.findByUuid(uuid);
        if(existingOrderEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen order bulunamadı!");
        }
        OrderEntity updatedEntity = orderMapper.updateEntityFromRequestDTO(existingOrderEntity.get(), dto);
        orderEntityRepository.save(updatedEntity);
        return orderMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<OrderEntity> existingOrderEntity = orderEntityRepository.findByUuid(uuid);

        if(existingOrderEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen order bulunamadı!");
        }
        orderEntityRepository.delete(existingOrderEntity.get());
    }

    public OrderDTO getByUuid(UUID uuid) {
        Optional<OrderEntity> foundOrderEntity = orderEntityRepository.findByUuid(uuid);

        if(foundOrderEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen order bulunamadı!");
        }
        return orderMapper.entityToDTO(foundOrderEntity.get());
    }
}
