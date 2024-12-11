package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.ChucNang;
import com.hotelmanagement.springHotel.service.CTQuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quyen")
@CrossOrigin
public class CTQuyenController {
    
    @Autowired
    private CTQuyenService ctQuyenService;

    @GetMapping("/{quyenId}/chuc-nang")
    public ResponseEntity<List<ChucNang>> getChucNangsByQuyenId(@PathVariable Long quyenId) {
        List<ChucNang> chucNangs = ctQuyenService.getChucNangsByQuyenId(quyenId);
        return ResponseEntity.ok(chucNangs);
    }

    @PutMapping("/{quyenId}/chuc-nang")
    public ResponseEntity<?> capNhatChucNangChoQuyen(
            @PathVariable Long quyenId,
            @RequestBody List<Long> chucNangIds) {
        try {
            ctQuyenService.capNhatChucNangChoQuyen(quyenId, chucNangIds);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 