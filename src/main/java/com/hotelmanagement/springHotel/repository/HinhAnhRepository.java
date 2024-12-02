package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Long> {
    List<HinhAnh> findByLoaiPhongId(Long loaiPhongId);
} 