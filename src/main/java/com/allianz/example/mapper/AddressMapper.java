package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper implements IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCreationDate(entity.getCreationDate());
        addressDTO.setUuid(entity.getUuid());
        addressDTO.setId(entity.getId());
        addressDTO.setAddress(entity.getAddress());
        addressDTO.setTitle(entity.getTitle());
        addressDTO.setUpdatedDate(entity.getUpdatedDate());


        return addressDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setTitle(dto.getTitle());
        addressEntity.setUuid(dto.getUuid());
        addressEntity.setId(dto.getId());
        addressEntity.setCreationDate(dto.getCreationDate());
        addressEntity.setUpdatedDate(dto.getUpdatedDate());
        addressEntity.setAddress(dto.getAddress());

        return addressEntity;
    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for (AddressEntity addressEntity:addressEntities) {
            addressDTOList.add(entityToDTO(addressEntity));
        }

        return addressDTOList;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        List<AddressEntity> addressEntityList = new ArrayList<>();

        for(AddressDTO addressDTO : addressDTOS){
            addressEntityList.add(dtoToEntity(addressDTO));
        }
        return addressEntityList;
    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();
        entity.setTitle(dto.getTitle());
        entity.setAddress(dto.getAddress());


        return entity;
    }

    public AddressEntity updateEntityFromRequestDTO(AddressEntity entity, AddressRequestDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setAddress(dto.getAddress());

        return entity;
    }



}
