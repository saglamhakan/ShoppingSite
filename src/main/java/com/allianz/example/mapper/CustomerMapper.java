package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {
    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setUuid(entity.getUuid());
        customerDTO.setPerson(entity.getPerson());
        customerDTO.setCreationDate(entity.getCreationDate());
        customerDTO.setUpdatedDate(entity.getUpdatedDate());
        customerDTO.setIsCorporate(entity.getIsCorporate());
        customerDTO.setCompanyName(entity.getCompanyName());
        customerDTO.setOrderList(entity.getOrderList());
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setTaxOffice(entity.getTaxNumber());

        return customerDTO;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setPerson(dto.getPerson());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setOrderList(dto.getOrderList());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxNumber());
        return entity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (CustomerEntity customerEntity: customerEntities){
            customerDTOList.add(entityToDTO(customerEntity));
        }

        return customerDTOList;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> customerEntityList = new ArrayList<>();

        for (CustomerDTO customerDTO: customerDTOS){
            customerEntityList.add(dtoToEntity(customerDTO));
        }

        return customerEntityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {
        CustomerEntity entity = new CustomerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setPerson(dto.getPerson());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setOrderList(dto.getOrderList());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxNumber());

        return entity;
    }

    public CustomerEntity updateEntityFromRequestDTO(CustomerEntity entity, CustomerRequestDTO dto) {

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setPerson(dto.getPerson());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setOrderList(dto.getOrderList());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxNumber());

        return entity;
    }
}
