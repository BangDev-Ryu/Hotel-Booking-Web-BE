package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.LoaiPhong;

import java.util.List;

public interface CTBookingLoaiPhongService {
    void updateBookingLoaiPhong(Long bookingId, List<Long> loaiPhongIds);
    List<LoaiPhong> getLoaiPhongByBooking(Long bookingId);
}
