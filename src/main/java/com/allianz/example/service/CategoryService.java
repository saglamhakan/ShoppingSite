package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryEntityRepository categoryEntityRepository;

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryEntityRepository categoryEntityRepository, CategoryMapper categoryMapper) {
        this.categoryEntityRepository = categoryEntityRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDTO save(CategoryRequestDTO dto) {
        CategoryEntity categoryEntity = categoryMapper.requestDTOToEntity(dto);
        categoryEntityRepository.save(categoryEntity);
        return categoryMapper.entityToDTO(categoryEntity);
    }


    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntityList = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntityList);
    }



    public CategoryDTO update(UUID uuid, CategoryRequestDTO dto) {
        Optional<CategoryEntity> existingCategoryEntity = categoryEntityRepository.findByUuid(uuid);
        if(existingCategoryEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen category bulunamadı!");
        }
        CategoryEntity updatedEntity = categoryMapper.updateEntityFromRequestDTO(existingCategoryEntity.get(), dto);
        categoryEntityRepository.save(updatedEntity);
        return categoryMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<CategoryEntity> existingCategoryEntity = categoryEntityRepository.findByUuid(uuid);

        if(existingCategoryEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen fatura bulunamadı!");
        }
        categoryEntityRepository.delete(existingCategoryEntity.get());
    }

    public CategoryDTO getByUuid(UUID uuid) {
        Optional<CategoryEntity> foundCategoryEntity = categoryEntityRepository.findByUuid(uuid);

        if(foundCategoryEntity.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen category bulunamadı!");
        }
        return categoryMapper.entityToDTO(foundCategoryEntity.get());
    }
}
