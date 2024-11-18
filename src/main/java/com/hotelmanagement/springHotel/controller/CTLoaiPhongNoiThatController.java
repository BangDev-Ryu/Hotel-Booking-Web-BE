package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.NoiThat;
import com.hotelmanagement.springHotel.service.CTLoaiPhongNoiThatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loai-phong")
@CrossOrigin
public class CTLoaiPhongNoiThatController {

    @Autowired
    private CTLoaiPhongNoiThatService ctLoaiPhongNoiThatService;

    @PostMapping("/{loaiPhongId}/noi-that")
    public ResponseEntity<Object> updateLoaiPhongNoiThat(
            @PathVariable Long loaiPhongId,
            @RequestBody List<Long> noiThatIds) {
        ctLoaiPhongNoiThatService.updateLoaiPhongNoiThat(loaiPhongId, noiThatIds);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{loaiPhongId}/noi-that")
    public ResponseEntity<List<NoiThat>> getNoiThatByLoaiPhong(@PathVariable Long loaiPhongId) {
        List<NoiThat> noiThats = ctLoaiPhongNoiThatService.getNoiThatByLoaiPhong(loaiPhongId);
        return ResponseEntity.ok(noiThats);
    }
}
