package com.allianz.example.controller;

import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.service.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("orderEntity")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<OrderItemDTO>> getAll(){
        return new ResponseEntity<>(orderItemService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<OrderItemDTO> save(@RequestBody OrderItemRequestDTO orderItemRequestDTO){
        return new ResponseEntity<>(orderItemService.save(orderItemRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<OrderItemDTO> update(@PathVariable UUID uuid, @RequestBody OrderItemRequestDTO orderItemRequestDTO){
        return new ResponseEntity<>(orderItemService.update(uuid, orderItemRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        orderItemService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<OrderItemDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(orderItemService.getByUuid(uuid), HttpStatus.OK);
    }
}
