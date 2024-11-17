package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loai-phong")
@CrossOrigin
public class LoaiPhongController {

    @Autowired
    private LoaiPhongService loaiPhongService;

    @GetMapping
    public List<LoaiPhong> getAllLoaiPhong() {
        return loaiPhongService.getAllLoaiPhong();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiPhong> getLoaiPhongById(@PathVariable Long id) {
        return loaiPhongService.getLoaiPhongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LoaiPhong createLoaiPhong(@RequestBody LoaiPhong loaiPhong) {
        return loaiPhongService.saveLoaiPhong(loaiPhong);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiPhong> updateLoaiPhong(@PathVariable Long id, @RequestBody LoaiPhong loaiPhong) {
        return loaiPhongService.getLoaiPhongById(id)
                .map(existingLoaiPhong -> {
                    loaiPhong.setId(id);
                    return ResponseEntity.ok(loaiPhongService.saveLoaiPhong(loaiPhong));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLoaiPhong(@PathVariable Long id) {
        return loaiPhongService.getLoaiPhongById(id)
                .map(loaiPhong -> {
                    loaiPhongService.deleteLoaiPhong(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 