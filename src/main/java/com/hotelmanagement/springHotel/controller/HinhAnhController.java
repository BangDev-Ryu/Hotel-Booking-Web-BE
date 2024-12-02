package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.HinhAnh;
import com.hotelmanagement.springHotel.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hinh-anh")
@CrossOrigin
public class HinhAnhController {

    @Autowired
    private HinhAnhService hinhAnhService;

    // Lấy tất cả hình ảnh
    @GetMapping
    public ResponseEntity<List<HinhAnh>> getAllHinhAnh() {
        return ResponseEntity.ok(hinhAnhService.getAllHinhAnh());
    }

    // Lấy hình ảnh theo ID
    @GetMapping("/{id}")
    public ResponseEntity<HinhAnh> getHinhAnhById(@PathVariable Long id) {
        return hinhAnhService.getHinhAnhById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tạo mới hình ảnh cho một loại phòng
    @PostMapping
    public ResponseEntity<HinhAnh> createHinhAnh(@RequestBody Map<String, Object> request) {
        try {
            String base64Data = (String) request.get("base64Data");
            Long loaiPhongId = Long.parseLong(request.get("loaiPhongId").toString());
            
            HinhAnh hinhAnh = hinhAnhService.createHinhAnh(base64Data, loaiPhongId);
            return ResponseEntity.ok(hinhAnh);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Cập nhật hình ảnh
    @PutMapping("/{id}")
    public ResponseEntity<HinhAnh> updateHinhAnh(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        try {
            String base64Data = request.get("base64Data");
            HinhAnh updatedHinhAnh = hinhAnhService.updateHinhAnh(id, base64Data);
            return ResponseEntity.ok(updatedHinhAnh);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Xóa hình ảnh
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHinhAnh(@PathVariable Long id) {
        try {
            hinhAnhService.deleteHinhAnh(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
