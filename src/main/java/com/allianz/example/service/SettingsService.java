package com.allianz.example.service;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.exception.BusinessException;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingsService {

    private final SettingsEntityRepository settingsEntityRepository;

    private final SettingsMapper settingsMapper;

    public SettingsService(SettingsEntityRepository settingsEntityRepository, SettingsMapper settingsMapper) {
        this.settingsEntityRepository = settingsEntityRepository;
        this.settingsMapper = settingsMapper;
    }

    public SettingsDTO save(SettingsRequestDTO dto) {
        Settings settings = settingsMapper.requestDTOToEntity(dto);
        settingsEntityRepository.save(settings);
        return settingsMapper.entityToDTO(settings);
    }


    public List<SettingsDTO> getAll() {
        List<Settings> settingsList = settingsEntityRepository.findAll();
        return settingsMapper.entityListToDTOList(settingsList);
    }



    public SettingsDTO update(UUID uuid, SettingsRequestDTO dto) {
        Optional<Settings> existingSettings = settingsEntityRepository.findByUuid(uuid);
        if(existingSettings.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen settings bulunamadı!");
        }
        Settings updatedEntity = settingsMapper.updateEntityFromRequestDTO(existingSettings.get(), dto);
        settingsEntityRepository.save(updatedEntity);
        return settingsMapper.entityToDTO(updatedEntity);
    }

    public void deleteByUuid(UUID uuid) {
        Optional<Settings> existingSettings = settingsEntityRepository.findByUuid(uuid);

        if(existingSettings.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen setting bulunamadı!");
        }
        settingsEntityRepository.delete(existingSettings.get());
    }

    public SettingsDTO getByUuid(UUID uuid) {
        Optional<Settings> foundSettings = settingsEntityRepository.findByUuid(uuid);

        if(foundSettings.isEmpty()) {
            throw new BusinessException("UUID ile belirtilen setting bulunamadı!");
        }
        return settingsMapper.entityToDTO(foundSettings.get());
    }
}
