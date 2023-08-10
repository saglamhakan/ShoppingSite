package com.allianz.example.controller;

import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.service.TaxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tax")
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TaxDTO>> getAll(){
        return new ResponseEntity<>(taxService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<TaxDTO> save(@RequestBody TaxRequestDTO taxRequestDTO){
        return new ResponseEntity<>(taxService.save(taxRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<TaxDTO> update(@PathVariable UUID uuid, @RequestBody TaxRequestDTO taxRequestDTO){
        return new ResponseEntity<>(taxService.update(uuid, taxRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        taxService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<TaxDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(taxService.getByUuid(uuid),HttpStatus.OK);
    }
}
