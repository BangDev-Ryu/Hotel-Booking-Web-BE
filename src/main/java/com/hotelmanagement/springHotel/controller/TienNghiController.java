package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.TienNghi;
import com.hotelmanagement.springHotel.service.TienNghiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tien-nghi")
@CrossOrigin
public class TienNghiController {

    @Autowired
    private TienNghiService tienNghiService;

    @GetMapping
    public List<TienNghi> getAllTienNghi() {
        return tienNghiService.getAllTienNghi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TienNghi> getTienNghiById(@PathVariable Long id) {
        return tienNghiService.getTienNghiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TienNghi createTienNghi(@RequestBody TienNghi tienNghi) {
        return tienNghiService.saveTienNghi(tienNghi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TienNghi> updateTienNghi(@PathVariable Long id, @RequestBody TienNghi tienNghi) {
        return tienNghiService.getTienNghiById(id)
                .map(existingTienNghi -> {
                    tienNghi.setId(id);
                    return ResponseEntity.ok(tienNghiService.saveTienNghi(tienNghi));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTienNghi(@PathVariable Long id) {
        return tienNghiService.getTienNghiById(id)
                .map(tienNghi -> {
                    tienNghiService.deleteTienNghi(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
