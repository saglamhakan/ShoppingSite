package com.allianz.example.controller;

import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<OrderDTO>> getAll(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);

    }

    @PostMapping("save")
    public ResponseEntity<OrderDTO> save(@RequestBody OrderRequestDTO orderRequestDTO){
        return new ResponseEntity<>(orderService.save(orderRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<OrderDTO> update(@PathVariable UUID uuid, @RequestBody OrderRequestDTO orderRequestDTO){
        return new ResponseEntity<>(orderService.update(uuid, orderRequestDTO),HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable UUID uuid){
        orderService.deleteByUuid(uuid);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<OrderDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(orderService.getByUuid(uuid), HttpStatus.OK);
    }
}
