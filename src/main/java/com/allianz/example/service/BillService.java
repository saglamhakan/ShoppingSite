package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BillService {

    private final BillEntityRepository billEntityRepository;

    private final BillMapper billMapper;


    public BillService(BillEntityRepository billEntityRepository, BillMapper billMapper) {
        this.billEntityRepository = billEntityRepository;
        this.billMapper = billMapper;
    }

    public BillDTO save(BillRequestDTO dto) {
        BillEntity billEntity = billMapper.requestDTOToEntity(dto);
        billEntityRepository.save(billEntity);
        return billMapper.entityToDTO(billEntity);
    }


    public List<BillDTO> getAll() {
        List<BillEntity> billEntityList = billEntityRepository.findAll();
        return billMapper.entityListToDTOList(billEntityList);
    }



    public BillDTO update(UUID uuid, BillRequestDTO dto) {
        Optional<BillEntity> existingBillEntity = billEntityRepository.findByUuid(uuid);
        if(existingBillEntity.isEmpty()) {
            throw new EntityNotFoundException("UUID ile belirtilen fatura bulunamadı!");
        }
        BillEntity updatedEntity = billMapper.updateEntityFromRequestDTO(existingBillEntity.get(), dto);
        billEntityRepository.save(updatedEntity);
        return billMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<BillEntity> existingBillEntity = billEntityRepository.findByUuid(uuid);

        if(existingBillEntity.isEmpty()) {
            throw new EntityNotFoundException("UUID ile belirtilen fatura bulunamadı!");
        }
        billEntityRepository.delete(existingBillEntity.get());
    }

    public BillDTO getByUuid(UUID uuid) {
        Optional<BillEntity> foundBillEntity = billEntityRepository.findByUuid(uuid);

        if(foundBillEntity.isEmpty()) {
            throw new EntityNotFoundException("UUID ile belirtilen fatura bulunamadı!");
        }
        return billMapper.entityToDTO(foundBillEntity.get());
    }
}

