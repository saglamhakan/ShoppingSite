package com.allianz.example.controller;

import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductRequestDTO productRequestDTO){
        return new ResponseEntity<>(productService.save(productRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID uuid, @RequestBody ProductRequestDTO productRequestDTO){
        return new ResponseEntity<>(productService.update(uuid, productRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        productService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<ProductDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(productService.getByUuid(uuid),HttpStatus.OK);
    }
}
