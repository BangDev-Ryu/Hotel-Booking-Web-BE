package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.Room;
import com.hotelmanagement.springHotel.service.CTBookingPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class CTBookingPhongController {

    @Autowired
    private CTBookingPhongService ctBookingPhongService;

    @PostMapping("/{bookingId}/room")
    public ResponseEntity<?> updateBookingRoom(@PathVariable Long bookingId, @RequestBody List<Long> roomIds) {
        try {
            ctBookingPhongService.updateBookingPhong(bookingId, roomIds);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{bookingId}/room")
    public ResponseEntity<?> getRoomByBooking(@PathVariable Long bookingId) {
        try {
            List<Room> rooms = ctBookingPhongService.getRoomByBooking(bookingId);
            return ResponseEntity.ok(rooms);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
