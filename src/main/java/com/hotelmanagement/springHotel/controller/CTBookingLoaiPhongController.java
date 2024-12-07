package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.service.CTBookingLoaiPhongService;
import lombok.Getter;
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
    public ResponseEntity<Object> updateBookingLoaiPhong(
        @PathVariable Long bookingId, 
        @RequestBody List<BookingRoomRequest> bookingRooms
    ) {
        try {
            ctBookingLoaiPhongService.updateBookingLoaiPhong(bookingId, bookingRooms);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{bookingId}/loai-phong")
    public ResponseEntity<List<LoaiPhong>> getLoaiPhongByBooking(@PathVariable Long bookingId) {
        List<LoaiPhong> loaiPhongs = ctBookingLoaiPhongService.getLoaiPhongByBooking(bookingId);
        return ResponseEntity.ok(loaiPhongs);
    }

    @Getter
    public static class BookingRoomRequest {
        private Long loaiPhongId;
        private int soLuong;

        public void setLoaiPhongId(Long loaiPhongId) { this.loaiPhongId = loaiPhongId; }

        public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    }
}
