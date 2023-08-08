package com.allianz.example.controller;

import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<BillDTO> updateBill(@PathVariable UUID uuid, @RequestBody BillRequestDTO dto){
        return new ResponseEntity<>(billService.update(uuid,dto), HttpStatus.OK);

    }

    @DeleteMapping("delete/{uuid}")
    public void deleteBill(@PathVariable UUID uuid){
        billService.deleteByUuid(uuid);
    }

}
