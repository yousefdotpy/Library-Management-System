package com.example.library.controller;

import com.example.library.dto.PatronDTO;
import com.example.library.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<PatronDTO> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatronDTO> getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PatronDTO addPatron(@RequestBody PatronDTO patronDTO) {
        return patronService.savePatron(patronDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronDTO> updatePatron(@PathVariable Long id, @RequestBody PatronDTO patronDTO) {
        return patronService.getPatronById(id)
                .map(existingPatron -> {
                    patronDTO.setPatronId(id);
                    return ResponseEntity.ok(patronService.savePatron(patronDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}