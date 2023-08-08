package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    OrderMapper orderMapper;


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
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setTaxOffice(entity.getTaxNumber());
        customerDTO.setOrderList(orderMapper.entityListToDTOList(entity.getOrderList()));

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
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxNumber());
        entity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));
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
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxNumber());
        entity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));


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
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxNumber());
        entity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));


        return entity;
    }
}
