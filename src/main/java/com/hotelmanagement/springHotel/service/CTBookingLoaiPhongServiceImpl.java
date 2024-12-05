package com.hotelmanagement.springHotel.service;

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
    public void updateBookingLoaiPhong(Long bookingId, List<Long> loaiPhongIds) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        ctBookingLoaiPhongRepository.deleteByBookingId(bookingId);

        for (Long loaiPhongId : loaiPhongIds) {
            LoaiPhong loaiPhong = loaiPhongRepository.findById(loaiPhongId)
                    .orElseThrow(() -> new RuntimeException("LoaiPhong not found"));

            CTBookingLoaiPhong ctBookingLoaiPhong = new CTBookingLoaiPhong();
            ctBookingLoaiPhong.setBooking(booking);
            ctBookingLoaiPhong.setLoaiPhong(loaiPhong);
            ctBookingLoaiPhongRepository.save(ctBookingLoaiPhong);
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
