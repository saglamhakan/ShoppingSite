package com.allianz.example.controller;

import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AddressDTO>> getAll(){
        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<AddressDTO> save(@RequestBody AddressRequestDTO addressRequestDTO){
        return new ResponseEntity<>(addressService.save(addressRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<AddressDTO> update(@PathVariable UUID uuid, @RequestBody AddressRequestDTO addressRequestDTO){
        return new ResponseEntity<>(addressService.update(uuid, addressRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        addressService.deleteByUuid(uuid);

    }

    @GetMapping("{uuid}")
    public ResponseEntity<AddressDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(addressService.getByUUID(uuid), HttpStatus.OK);
    }

}
