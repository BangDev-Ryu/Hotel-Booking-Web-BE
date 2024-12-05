package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.CTBookingLoaiPhong;
import com.hotelmanagement.springHotel.model.CTBookingLoaiPhongId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CTBookingLoaiPhongRepository extends JpaRepository<CTBookingLoaiPhong, CTBookingLoaiPhongId> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CTBookingLoaiPhong ct WHERE ct.booking.id_booking = :bookingId")
    void deleteByBookingId(Long bookingId);
}
