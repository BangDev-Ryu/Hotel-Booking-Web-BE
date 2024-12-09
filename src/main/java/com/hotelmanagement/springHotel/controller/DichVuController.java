package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.DichVu;
import com.hotelmanagement.springHotel.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dich-vu")
@CrossOrigin
public class DichVuController {

    @Autowired
    private DichVuService dichVuService;

    @GetMapping
    public List<DichVu> getAllDichVu() {
        return dichVuService.getAllDichVu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DichVu> getDichVuById(@PathVariable Long id) {
        return dichVuService.getDichVuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DichVu createDichVu(@RequestBody DichVu dichVu) {
        return dichVuService.saveDichVu(dichVu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DichVu> updateDichVu(@PathVariable Long id, @RequestBody DichVu dichVu) {
        return dichVuService.getDichVuById(id)
                .map(existingDichVu -> {
                    dichVu.setId(id);
                    return ResponseEntity.ok(dichVuService.saveDichVu(dichVu));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDichVu(@PathVariable Long id) {
        return dichVuService.getDichVuById(id)
                .map(dichVu -> {
                    dichVuService.deleteDichVu(id);
                    return  ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
