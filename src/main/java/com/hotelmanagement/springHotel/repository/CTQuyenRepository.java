package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.CTQuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTQuyenRepository extends JpaRepository<CTQuyen, Long> {
    List<CTQuyen> findByQuyenId(Long quyenId);
    void deleteByQuyenId(Long quyenId);
    void deleteByQuyenIdAndChucNangId(Long quyenId, Long chucNangId);
} 