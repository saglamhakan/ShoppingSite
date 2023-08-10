package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("PersonDTO")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("getAll")
    public ResponseEntity<List<PersonDTO>> getAll(){
        return new ResponseEntity<>(personService.getAll(),HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<PersonDTO> save(@RequestBody PersonRequestDTO personRequestDTO){
        return new ResponseEntity<>(personService.save(personRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<PersonDTO> update(@PathVariable UUID uuid, @RequestBody PersonRequestDTO personRequestDTO){
        return new ResponseEntity<>(personService.update(uuid, personRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        personService.deleteByUuid(uuid);
    }
}