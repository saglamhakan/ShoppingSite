package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductEntityRepository productEntityRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductEntityRepository productEntityRepository, ProductMapper productMapper) {
        this.productEntityRepository = productEntityRepository;
        this.productMapper = productMapper;
    }
    public ProductDTO save(ProductRequestDTO dto) {
        ProductEntity productEntity = productMapper.requestDTOToEntity(dto);
        productEntityRepository.save(productEntity);
        return productMapper.entityToDTO(productEntity);
    }


    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntityList = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntityList);
    }



    public ProductDTO update(UUID uuid, ProductRequestDTO dto) {
        Optional<ProductEntity> existingProductEntity = productEntityRepository.findByUuid(uuid);
        if(existingProductEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen product bulunamadı!");
        }
        ProductEntity updatedEntity = productMapper.updateEntityFromRequestDTO(existingProductEntity.get(), dto);
        productEntityRepository.save(updatedEntity);
        return productMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<ProductEntity> existingProductEntity = productEntityRepository.findByUuid(uuid);

        if(existingProductEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen product bulunamadı!");
        }
        productEntityRepository.delete(existingProductEntity.get());
    }

    public ProductDTO getByUuid(UUID uuid) {
        Optional<ProductEntity> foundProductEntity = productEntityRepository.findByUuid(uuid);

        if(foundProductEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen product bulunamadı!");
        }
        return productMapper.entityToDTO(foundProductEntity.get());
    }
}
