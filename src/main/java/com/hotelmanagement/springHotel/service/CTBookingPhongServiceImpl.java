package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Booking;
import com.hotelmanagement.springHotel.model.CTBookingPhong;
import com.hotelmanagement.springHotel.model.Room;
import com.hotelmanagement.springHotel.repository.BookingRepository;
import com.hotelmanagement.springHotel.repository.CTBookingPhongRepository;
import com.hotelmanagement.springHotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTBookingPhongServiceImpl implements CTBookingPhongService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CTBookingPhongRepository ctBookingPhongRepository;

    @Override
    @Transactional
    public void updateBookingPhong(Long bookingId, List<Long> roomIds) {
        try {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy booking"));

            // Xóa các liên kết phòng cũ
            ctBookingPhongRepository.deleteByBookingId(bookingId);

            // Thêm các liên kết phòng mới
            List<CTBookingPhong> newBookingPhongs = roomIds.stream()
                    .map(roomId -> {
                        Room room = roomRepository.findById(roomId)
                                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng: " + roomId));
                        CTBookingPhong ctBookingPhong = new CTBookingPhong();
                        ctBookingPhong.setBooking(booking);
                        ctBookingPhong.setRoom(room);
                        return ctBookingPhong;
                    })
                    .collect(Collectors.toList());

            ctBookingPhongRepository.saveAll(newBookingPhongs);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi cập nhật phòng cho booking: " + e.getMessage());
        }
    }

    @Override
    public List<Room> getRoomByBooking(Long bookingId) {
        try {
            // Sử dụng query trực tiếp thay vì stream
            return ctBookingPhongRepository.findRoomsByBookingId(bookingId);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi lấy danh sách phòng của booking: " + e.getMessage());
        }
    }
}
