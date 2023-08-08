package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaxService {

    private final TaxEntityRepository taxEntityRepository;

    private final TaxMapper taxMapper;

    public TaxService(TaxEntityRepository taxEntityRepository, TaxMapper taxMapper) {
        this.taxEntityRepository = taxEntityRepository;
        this.taxMapper = taxMapper;
    }

    public TaxDTO save(TaxRequestDTO dto) {
        TaxEntity taxEntity = taxMapper.requestDTOToEntity(dto);
        taxEntityRepository.save(taxEntity);
        return taxMapper.entityToDTO(taxEntity);
    }


    public List<TaxDTO> getAll() {
        List<TaxEntity> taxEntityList = taxEntityRepository.findAll();
        return taxMapper.entityListToDTOList(taxEntityList);
    }



    public TaxDTO update(UUID uuid, TaxRequestDTO dto) {
        Optional<TaxEntity> existingTaxEntity = taxEntityRepository.findByUuid(uuid);
        if(existingTaxEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen tax bulunamadı!");
        }
        TaxEntity updatedEntity = taxMapper.updateEntityFromRequestDTO(existingTaxEntity.get(), dto);
        taxEntityRepository.save(updatedEntity);
        return taxMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<TaxEntity> existingTaxEntity = taxEntityRepository.findByUuid(uuid);

        if(existingTaxEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen tax bulunamadı!");
        }
        taxEntityRepository.delete(existingTaxEntity.get());
    }

    public TaxDTO getByUuid(UUID uuid) {
        Optional<TaxEntity> foundTaxEntity = taxEntityRepository.findByUuid(uuid);

        if(foundTaxEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen tax bulunamadı!");
        }
        return taxMapper.entityToDTO(foundTaxEntity.get());
    }
}
