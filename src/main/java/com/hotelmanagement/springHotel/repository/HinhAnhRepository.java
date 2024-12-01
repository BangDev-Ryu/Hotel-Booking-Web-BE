package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HinhAnhRepository extends JpaRepository<HinhAnh, Long> {
    List<HinhAnh> findByLoaiPhongId(Long loaiPhongId);
} 