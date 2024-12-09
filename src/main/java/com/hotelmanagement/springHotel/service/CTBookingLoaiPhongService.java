package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.controller.CTBookingLoaiPhongController;
import com.hotelmanagement.springHotel.model.CTBookingLoaiPhong;
import com.hotelmanagement.springHotel.model.LoaiPhong;

import java.util.List;

public interface CTBookingLoaiPhongService {
    public void updateBookingLoaiPhong(Long bookingId, List<CTBookingLoaiPhongController.BookingRoomRequest> bookingRooms);
    List<CTBookingLoaiPhong> getCTLoaiPhongByBooking(Long bookingId);
}
