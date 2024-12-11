package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.ChucNang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChucNangRepository extends JpaRepository<ChucNang, Long> {
    Optional<ChucNang> findByHanhDongAndDoiTuong(String hanhDong, String doiTuong);
} 