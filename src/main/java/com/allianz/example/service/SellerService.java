package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellerService {

    private final SellerEntityRepository sellerEntityRepository;
    private final SellerMapper sellerMapper;

    public SellerService(SellerEntityRepository sellerEntityRepository, SellerMapper sellerMapper) {
        this.sellerEntityRepository = sellerEntityRepository;
        this.sellerMapper = sellerMapper;
    }

    public SellerDTO save(SellerRequestDTO dto) {
        SellerEntity sellerEntity = sellerMapper.requestDTOToEntity(dto);
        sellerEntityRepository.save(sellerEntity);
        return sellerMapper.entityToDTO(sellerEntity);
    }


    public List<SellerDTO> getAll() {
        List<SellerEntity> sellerEntityList = sellerEntityRepository.findAll();
        return sellerMapper.entityListToDTOList(sellerEntityList);
    }



    public SellerDTO update(UUID uuid, SellerRequestDTO dto) {
        Optional<SellerEntity> existingSellerEntity = sellerEntityRepository.findByUuid(uuid);
        if(existingSellerEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen seller bulunamadı!");
        }
        SellerEntity updatedEntity = sellerMapper.updateEntityFromRequestDTO(existingSellerEntity.get(), dto);
        sellerEntityRepository.save(updatedEntity);
        return sellerMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<SellerEntity> existingSellerEntity = sellerEntityRepository.findByUuid(uuid);

        if(existingSellerEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen seller bulunamadı!");
        }
        sellerEntityRepository.delete(existingSellerEntity.get());
    }

    public SellerDTO getByUuid(UUID uuid) {
        Optional<SellerEntity> foundSellerEntity = sellerEntityRepository.findByUuid(uuid);

        if(foundSellerEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen seller bulunamadı!");
        }
        return sellerMapper.entityToDTO(foundSellerEntity.get());
    }
}
