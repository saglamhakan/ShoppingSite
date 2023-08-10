package com.allianz.example.controller;

import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<SellerDTO>> getAll(){
        return new ResponseEntity<>(sellerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<SellerDTO> save(@RequestBody SellerRequestDTO sellerRequestDTO){
        return new ResponseEntity<>(sellerService.save(sellerRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<SellerDTO> update(@PathVariable UUID uuid, @RequestBody SellerRequestDTO sellerRequestDTO){
        return new ResponseEntity<>(sellerService.update(uuid, sellerRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        sellerService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<SellerDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(sellerService.getByUuid(uuid),HttpStatus.OK);
    }
}
