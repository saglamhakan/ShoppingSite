package com.allianz.example.controller;

import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CustomerDTO>>  getAll(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerRequestDTO customerRequestDTO){
        return new ResponseEntity<>(customerService.save(customerRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<CustomerDTO> update(@PathVariable UUID uuid, @RequestBody CustomerRequestDTO customerRequestDTO){
        return new ResponseEntity<>(customerService.update(uuid, customerRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        customerService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<CustomerDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(customerService.getByUuid(uuid), HttpStatus.OK);
    }
}
