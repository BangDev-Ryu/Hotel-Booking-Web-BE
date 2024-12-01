package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.HinhAnh;
import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.repository.HinhAnhRepository;
import com.hotelmanagement.springHotel.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            // Lấy dữ liệu base64 từ request
            String base64Data = request.get("base64Data");
            if (base64Data == null) {
                return ResponseEntity.badRequest().build();
            }

            // Tìm loại phòng theo id
            Optional<LoaiPhong> loaiPhongOpt = loaiPhongService.getLoaiPhongById(id);
            if (!loaiPhongOpt.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            // Tạo và lưu hình ảnh mới
            HinhAnh hinhAnh = new HinhAnh();
            hinhAnh.setBase64Data(base64Data);
            hinhAnh.setLoaiPhong(loaiPhongOpt.get());
            
            HinhAnh savedHinhAnh = hinhAnhRepository.save(hinhAnh);
            return ResponseEntity.ok(savedHinhAnh);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
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
} 