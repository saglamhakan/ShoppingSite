package com.allianz.example.mapper;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper implements IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Override
    public SellerDTO entityToDTO(SellerEntity entity) {
        SellerDTO sellerDTO = new SellerDTO();

        sellerDTO.setId(entity.getId());
        sellerDTO.setUuid(entity.getUuid());
        sellerDTO.setName(entity.getName());
        sellerDTO.setSurname(entity.getSurname());
        sellerDTO.setEmail(entity.getEmail());
        sellerDTO.setTc(entity.getTc());
        sellerDTO.setCreationDate(entity.getCreationDate());
        sellerDTO.setUpdatedDate(entity.getCreationDate());
        sellerDTO.setShopName(entity.getShopName());
        sellerDTO.setTaxNumber(entity.getTaxNumber());
        sellerDTO.setTaxOffice(entity.getTaxOffice());

        return sellerDTO;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {
        SellerEntity entity = new SellerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setTc(dto.getTc());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getCreationDate());
        entity.setShopName(dto.getShopName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());

        return entity;
    }

    @Override
    public List<SellerDTO> entityListToDTOList(List<SellerEntity> sellerEntities) {
        List<SellerDTO> sellerDTOS = new ArrayList<>();

        for (SellerEntity sellerEntity: sellerEntities){
            sellerDTOS.add(entityToDTO(sellerEntity));
        }

        return sellerDTOS;
    }

    @Override
    public List<SellerEntity> dtoListTOEntityList(List<SellerDTO> sellerDTOS) {
        List<SellerEntity> sellerEntityList = new ArrayList<>();

        for (SellerDTO sellerDTO: sellerDTOS){
            sellerEntityList.add(dtoToEntity(sellerDTO));
        }
        return sellerEntityList;
    }

    @Override
    public SellerEntity requestDTOToEntity(SellerRequestDTO dto) {
        SellerEntity entity = new SellerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setTc(dto.getTc());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getCreationDate());
        entity.setShopName(dto.getShopName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());

        return entity;
    }

    public SellerEntity updateEntityFromRequestDTO(SellerEntity entity,SellerRequestDTO dto) {

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setTc(dto.getTc());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getCreationDate());
        entity.setShopName(dto.getShopName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());

        return entity;
    }
}
