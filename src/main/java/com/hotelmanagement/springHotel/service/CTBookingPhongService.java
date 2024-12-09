package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Room;

import java.util.List;

public interface CTBookingPhongService {
    void updateBookingPhong(Long bookingId, List<Long> roomIds);
    List<Room> getRoomByBooking(Long bookingId);
}
