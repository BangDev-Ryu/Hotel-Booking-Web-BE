package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.HinhAnh;
import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.repository.HinhAnhRepository;
import com.hotelmanagement.springHotel.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/loai-phong")
@CrossOrigin
public class LoaiPhongController {

    @Autowired
    private LoaiPhongService loaiPhongService;

    @Autowired
    private HinhAnhRepository hinhAnhRepository;

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

    @GetMapping("/{id}/hinh-anh")
    public ResponseEntity<List<HinhAnh>> getHinhAnhByLoaiPhong(@PathVariable Long id) {
        return ResponseEntity.ok(hinhAnhRepository.findByLoaiPhongId(id));
    }

    @PostMapping("/{id}/hinh-anh")
    public ResponseEntity<HinhAnh> addHinhAnh(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            // Kiểm tra loại phòng tồn tại
            if (!loaiPhongService.getLoaiPhongById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }

            String base64Data = request.get("base64Data");
            if (base64Data == null || base64Data.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            
            // Tạo và lưu hình ảnh mới
            HinhAnh hinhAnh = new HinhAnh();
            hinhAnh.setBase64Data(base64Data);
            hinhAnh.setLoaiPhongId(id);

            HinhAnh savedHinhAnh = hinhAnhRepository.save(hinhAnh);
            return ResponseEntity.ok(savedHinhAnh);

        } catch (Exception e) {
            System.err.println("Error processing request: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{loaiPhongId}/hinh-anh/{hinhAnhId}")
    public ResponseEntity<Void> deleteHinhAnh(@PathVariable Long loaiPhongId, @PathVariable Long hinhAnhId) {
        if (hinhAnhRepository.existsById(hinhAnhId)) {
            hinhAnhRepository.deleteById(hinhAnhId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<Map<String, Object>> getLoaiPhongDetails(@PathVariable Long id) {
        Optional<LoaiPhong> loaiPhongOpt = loaiPhongService.getLoaiPhongById(id);
        if (!loaiPhongOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        LoaiPhong loaiPhong = loaiPhongOpt.get();
        List<HinhAnh> images = hinhAnhRepository.findByLoaiPhongId(id);

        Map<String, Object> response = new HashMap<>();
        response.put("loaiPhong", loaiPhong);
        response.put("images", images);

        return ResponseEntity.ok(response);
    }
} 