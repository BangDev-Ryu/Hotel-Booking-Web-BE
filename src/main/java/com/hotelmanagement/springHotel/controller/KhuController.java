package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.Khu;
import com.hotelmanagement.springHotel.service.KhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khu")
@CrossOrigin
public class KhuController {
    
    @Autowired
    private KhuService khuService;

    // Lấy danh sách tất cả khu
    @GetMapping
    public List<Khu> getAllKhu() {
        return khuService.getAllKhu();
    }

    // Lấy thông tin một khu theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Khu> getKhuById(@PathVariable Long id) {
        return khuService.getKhuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tạo khu mới
    @PostMapping
    public Khu createKhu(@RequestBody Khu khu) {
        return khuService.saveKhu(khu);
    }

    // Cập nhật thông tin khu
    @PutMapping("/{id}")
    public ResponseEntity<Khu> updateKhu(@PathVariable Long id, @RequestBody Khu khu) {
        return khuService.getKhuById(id)
                .map(existingKhu -> {
                    khu.setId(id);
                    return ResponseEntity.ok(khuService.saveKhu(khu));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Xóa khu
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteKhu(@PathVariable Long id) {
        return khuService.getKhuById(id)
                .map(khu -> {
                    khuService.deleteKhu(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
