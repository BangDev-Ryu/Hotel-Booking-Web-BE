package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.CTHoaDon;
import com.hotelmanagement.springHotel.model.CTHoaDonId;
import com.hotelmanagement.springHotel.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CTHoaDonRepository extends JpaRepository<CTHoaDon, CTHoaDonId> {
    List<CTHoaDon> findByHoaDon(HoaDon hoaDon);
}
