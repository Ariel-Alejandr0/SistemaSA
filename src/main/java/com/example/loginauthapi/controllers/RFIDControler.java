package com.example.loginauthapi.controllers;


import com.example.loginauthapi.domain.user.RFID;
import com.example.loginauthapi.service.xadrez.RFIDDTO;
import com.example.loginauthapi.service.xadrez.RFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rfid")
public class RFIDControler {

    private final RFIDService rfidService;

    @Autowired
    public RFIDControler(RFIDService rfidService) {
        this.rfidService = rfidService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRFID(@RequestBody RFIDDTO rfiddto) {
        rfidService.createRFID(rfiddto);
        return new ResponseEntity<>("RFID created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRFID(@RequestBody RFIDDTO rfiddto) {
        try {
            rfidService.updateRFID(rfiddto);
            return new ResponseEntity<>("RFID updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RFID> getRFIDById(@PathVariable Long id) {
        try {
            RFID rfid = rfidService.findById(id);
            return new ResponseEntity<>(rfid, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<RFID>> getAllRFIDs() {
        List<RFID> rfids = rfidService.findAll();
        return new ResponseEntity<>(rfids, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRFID(@PathVariable Long id) {
        try {
            rfidService.deleteById(id);
            return new ResponseEntity<>("RFID deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
