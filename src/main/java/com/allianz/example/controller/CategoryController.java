package com.allianz.example.controller;

import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return new ResponseEntity<>(categoryService.save(categoryRequestDTO),HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<CategoryDTO> update(@PathVariable UUID uuid, @RequestBody CategoryRequestDTO categoryRequestDTO){
        return new ResponseEntity<>(categoryService.update(uuid, categoryRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        categoryService.deleteByUuid(uuid);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<CategoryDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(categoryService.getByUuid(uuid), HttpStatus.OK);
    }
}
