package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.Quyen;
import com.hotelmanagement.springHotel.service.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quyen")
@CrossOrigin
public class QuyenController {

    @Autowired
    private QuyenService quyenService;

    @GetMapping
    public List<Quyen> getAllQuyen() {
        return quyenService.getAllQuyen();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quyen> getQuyenById(@PathVariable Long id) {
        return quyenService.getQuyenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quyen createQuyen(@RequestBody Quyen quyen) {
        return quyenService.saveQuyen(quyen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quyen> updateQuyen(@PathVariable Long id, @RequestBody Quyen quyen) {
        return quyenService.getQuyenById(id)
                .map(existingQuyen -> {
                    quyen.setId(id);
                    return ResponseEntity.ok(quyenService.saveQuyen(quyen));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delelteQuyen(@PathVariable Long id) {
        return quyenService.getQuyenById(id)
                .map(quyen -> {
                    quyenService.deleteQuyen(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
