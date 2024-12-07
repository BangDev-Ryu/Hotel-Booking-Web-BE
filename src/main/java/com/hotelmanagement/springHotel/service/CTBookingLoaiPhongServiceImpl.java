package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.controller.CTBookingLoaiPhongController;
import com.hotelmanagement.springHotel.model.Booking;
import com.hotelmanagement.springHotel.model.CTBookingLoaiPhong;
import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.repository.BookingRepository;
import com.hotelmanagement.springHotel.repository.CTBookingLoaiPhongRepository;
import com.hotelmanagement.springHotel.repository.LoaiPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTBookingLoaiPhongServiceImpl implements CTBookingLoaiPhongService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

    @Autowired
    private CTBookingLoaiPhongRepository ctBookingLoaiPhongRepository;

    @Override
    public void updateBookingLoaiPhong(Long bookingId, List<CTBookingLoaiPhongController.BookingRoomRequest> bookingRooms) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy booking"));

        for (CTBookingLoaiPhongController.BookingRoomRequest request : bookingRooms) {
            LoaiPhong loaiPhong = loaiPhongRepository.findById(request.getLoaiPhongId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại phòng"));

            CTBookingLoaiPhong ctBooking = new CTBookingLoaiPhong();
            ctBooking.setBooking(booking);
            ctBooking.setLoaiPhong(loaiPhong);
            ctBooking.setRoomQuantity(request.getSoLuong());
            ctBooking.setPrice(loaiPhong.getPrice());

            ctBookingLoaiPhongRepository.save(ctBooking);
        }
    }

    @Override
    public List<LoaiPhong> getLoaiPhongByBooking(Long bookingId) {
        return ctBookingLoaiPhongRepository.findAll().stream()
                .filter(ct -> ct.getLoaiPhong().getId().equals(bookingId))
                .map(CTBookingLoaiPhong::getLoaiPhong)
                .collect(Collectors.toList());
    }
}
