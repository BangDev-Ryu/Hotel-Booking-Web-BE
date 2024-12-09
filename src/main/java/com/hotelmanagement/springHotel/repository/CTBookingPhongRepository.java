package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.CTBookingPhong;
import com.hotelmanagement.springHotel.model.CTBookingPhongId;
import com.hotelmanagement.springHotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CTBookingPhongRepository extends JpaRepository<CTBookingPhong, CTBookingPhongId> {

    @Query("SELECT ct.room FROM CTBookingPhong ct WHERE ct.booking.id_booking = :bookingId")
    List<Room> findRoomsByBookingId(Long bookingId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CTBookingPhong ct WHERE ct.booking.id_booking = :bookingId")
    void deleteByBookingId(Long bookingId);
}
