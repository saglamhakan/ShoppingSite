package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerEntityRepository customerEntityRepository;

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerEntityRepository customerEntityRepository, CustomerMapper customerMapper) {
        this.customerEntityRepository = customerEntityRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO save(CustomerRequestDTO dto) {
        CustomerEntity customerEntity = customerMapper.requestDTOToEntity(dto);
        customerEntityRepository.save(customerEntity);
        return customerMapper.entityToDTO(customerEntity);
    }


    public List<CustomerDTO> getAll() {
        List<CustomerEntity> customerEntityList = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(customerEntityList);
    }



    public CustomerDTO update(UUID uuid, CustomerRequestDTO dto) {
        Optional<CustomerEntity> existingCustomerEntity = customerEntityRepository.findByUuid(uuid);
        if(existingCustomerEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen customer bulunamadı!");
        }
        CustomerEntity updatedEntity = customerMapper.updateEntityFromRequestDTO(existingCustomerEntity.get(), dto);
        customerEntityRepository.save(updatedEntity);
        return customerMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<CustomerEntity> existingCustomerEntity = customerEntityRepository.findByUuid(uuid);

        if(existingCustomerEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen fatura bulunamadı!");
        }
        customerEntityRepository.delete(existingCustomerEntity.get());
    }

    public CustomerDTO getByUuid(UUID uuid) {
        Optional<CustomerEntity> foundCustomerEntity = customerEntityRepository.findByUuid(uuid);

        if(foundCustomerEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen customer bulunamadı!");
        }
        return customerMapper.entityToDTO(foundCustomerEntity.get());
    }
}
