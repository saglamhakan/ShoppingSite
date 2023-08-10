package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService {

    private final PersonEntityRepository personEntityRepository;

    private final PersonMapper personMapper;

    public PersonService(PersonEntityRepository personEntityRepository, PersonMapper personMapper) {
        this.personEntityRepository = personEntityRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO save(PersonRequestDTO dto) {
        PersonEntity personEntity = personMapper.requestDTOToEntity(dto);
        personEntityRepository.save(personEntity);
        return personMapper.entityToDTO(personEntity);
    }


    public List<PersonDTO> getAll() {
        List<PersonEntity> personEntityList = personEntityRepository.findAll();
        return personMapper.entityListToDTOList(personEntityList);
    }



    public PersonDTO update(UUID uuid, PersonRequestDTO dto) {
        Optional<PersonEntity> existingPersonEntity = personEntityRepository.findByUuid(uuid);
        if(existingPersonEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen person bulunamadı!");
        }
        PersonEntity updatedEntity = personMapper.updateEntityFromRequestDTO(existingPersonEntity.get(), dto);
        personEntityRepository.save(updatedEntity);
        return personMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<PersonEntity> existingPersonEntity = personEntityRepository.findByUuid(uuid);

        if(existingPersonEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen person bulunamadı!");
        }
        personEntityRepository.delete(existingPersonEntity.get());
    }

    public PersonDTO getByUuid(UUID uuid) {
        Optional<PersonEntity> foundPersonEntity = personEntityRepository.findByUuid(uuid);

        if(foundPersonEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen person bulunamadı!");
        }
        return personMapper.entityToDTO(foundPersonEntity.get());
    }

}
