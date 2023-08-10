package com.allianz.example.controller;

import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<BillDTO>> getAll(){
        return new ResponseEntity<>(billService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<BillDTO> save(@RequestBody BillRequestDTO billRequestDTO){
        return new ResponseEntity<>(billService.save(billRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<BillDTO> updateBill(@PathVariable UUID uuid, @RequestBody BillRequestDTO dto){
        return new ResponseEntity<>(billService.update(uuid,dto), HttpStatus.OK);

    }

    @DeleteMapping("delete/{uuid}")
    public void deleteBill(@PathVariable UUID uuid){
        billService.deleteByUuid(uuid);
    }

    @GetMapping("uuid")
    public ResponseEntity<BillDTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(billService.getByUuid(uuid),HttpStatus.OK);
    }

}
