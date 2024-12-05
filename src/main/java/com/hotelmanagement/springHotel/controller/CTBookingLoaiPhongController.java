package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.service.CTBookingLoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class CTBookingLoaiPhongController {

    @Autowired
    private CTBookingLoaiPhongService ctBookingLoaiPhongService;

    @PostMapping("/{bookingId}/loai-phong")
    public ResponseEntity<Object> updateBookingLoaiPhong(@PathVariable Long bookingId, @RequestBody List<Long> loaiPhongIds) {
        ctBookingLoaiPhongService.updateBookingLoaiPhong(bookingId, loaiPhongIds);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{bookingId}/loai-phong")
    public ResponseEntity<List<LoaiPhong>> getLoaiPhongByBooking(@PathVariable Long bookingId) {
        List<LoaiPhong> loaiPhongs = ctBookingLoaiPhongService.getLoaiPhongByBooking(bookingId);
        return ResponseEntity.ok(loaiPhongs);
    }
}
