package com.allianz.example.controller;

import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.service.SettingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("settings")
public class SettingsController {

    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }
    @GetMapping("getAll")
    public ResponseEntity<List<SettingsDTO>> getAll(){
        return new ResponseEntity<>(settingsService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<SettingsDTO> save(@RequestBody SettingsRequestDTO settingsRequestDTO){
        return new ResponseEntity<>(settingsService.save(settingsRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<SettingsDTO> update(@PathVariable UUID uuid, @RequestBody SettingsRequestDTO settingsRequestDTO){
        return new ResponseEntity<>(settingsService.update(uuid, settingsRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        settingsService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<SettingsDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(settingsService.getByUuid(uuid),HttpStatus.OK);
    }
}
