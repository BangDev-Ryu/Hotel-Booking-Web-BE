package com.hotelmanagement.springHotel.controller;


import com.hotelmanagement.springHotel.model.TienNghi;
import com.hotelmanagement.springHotel.service.CTLoaiPhongTienNghiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loai-phong")
@CrossOrigin
public class CTLoaiPhongTienNghiController {

    @Autowired
    private CTLoaiPhongTienNghiService ctLoaiPhongTienNghiService;

    @PostMapping("/{loaiPhongId}/tien-nghi")
    public ResponseEntity<Object> updateLoaiPhongTienNghi(
            @PathVariable Long loaiPhongId,
            @RequestBody List<Long> tienNghiIds) {
        ctLoaiPhongTienNghiService.updateLoaiPhongTienNghi(loaiPhongId, tienNghiIds);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{loaiPhongId}/tien-nghi")
    public ResponseEntity<List<TienNghi>> getTienNghiByLoaiPhong(@PathVariable Long loaiPhongId) {
        List<TienNghi> tienNghis = ctLoaiPhongTienNghiService.getTienNghiByLoaiPhong(loaiPhongId);
        return ResponseEntity.ok(tienNghis);
    }
}
