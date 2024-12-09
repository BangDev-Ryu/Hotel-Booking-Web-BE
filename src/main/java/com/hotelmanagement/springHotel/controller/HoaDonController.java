package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.HoaDon;
import com.hotelmanagement.springHotel.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoa-don")
@CrossOrigin
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping
    public List<HoaDon> getAllHoaDon() {
        return hoaDonService.getAllHoaDon();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoaDon> getHoaDonById(@PathVariable Long id) {
        return hoaDonService.getHoaDonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HoaDon createHoaDon(@RequestBody HoaDon hoaDon) {
        return hoaDonService.saveHoaDon(hoaDon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoaDon> updateHoaDon(@PathVariable Long id, @RequestBody HoaDon hoaDon) {
        return hoaDonService.getHoaDonById(id)
                .map(existingHoaDon -> {
                    hoaDon.setId(id);
                    return ResponseEntity.ok(hoaDonService.saveHoaDon(hoaDon));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHoaDon(@PathVariable Long id) {
        return hoaDonService.getHoaDonById(id)
                .map(hoaDon -> {
                    hoaDonService.deleteHoaDon(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
