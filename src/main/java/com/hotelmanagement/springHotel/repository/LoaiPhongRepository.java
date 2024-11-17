package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiPhongRepository extends JpaRepository<LoaiPhong, Long> {
} 