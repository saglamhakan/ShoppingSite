package com.allianz.example.mapper;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMapper implements IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {
    @Override
    public TaxDTO entityToDTO(TaxEntity entity) {
        TaxDTO taxDTO = new TaxDTO();

        taxDTO.setId(entity.getId());
        taxDTO.setUuid(entity.getUuid());
        taxDTO.setName(entity.getName());
        taxDTO.setRate(entity.getRate());
        taxDTO.setCode(entity.getCode());
        taxDTO.setCreationDate(entity.getCreationDate());
        taxDTO.setUpdatedDate(entity.getUpdatedDate());

        return taxDTO;
    }

    @Override
    public TaxEntity dtoToEntity(TaxDTO dto) {
        TaxEntity entity = new TaxEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setCode(dto.getCode());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<TaxDTO> entityListToDTOList(List<TaxEntity> taxEntities) {
        List<TaxDTO> taxDTOList = new ArrayList<>();

        for (TaxEntity tax: taxEntities){
            taxDTOList.add(entityToDTO(tax));
        }

        return taxDTOList;
    }

    @Override
    public List<TaxEntity> dtoListTOEntityList(List<TaxDTO> taxDTOS) {
        List<TaxEntity> taxEntityList = new ArrayList<>();

        for (TaxDTO taxDTO: taxDTOS){
            taxEntityList.add(dtoToEntity(taxDTO));
        }

        return taxEntityList;
    }

    @Override
    public TaxEntity requestDTOToEntity(TaxRequestDTO dto) {
        TaxEntity entity = new TaxEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setCode(dto.getCode());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    public TaxEntity updateEntityFromRequestDTO(TaxEntity entity, TaxRequestDTO dto) {

        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setCode(dto.getCode());


        return entity;
    }
}
