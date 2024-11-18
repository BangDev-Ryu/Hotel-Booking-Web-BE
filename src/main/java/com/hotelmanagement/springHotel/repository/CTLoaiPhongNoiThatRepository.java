package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.CTLoaiPhongNoiThat;
import com.hotelmanagement.springHotel.model.CTLoaiPhongNoiThatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CTLoaiPhongNoiThatRepository extends JpaRepository<CTLoaiPhongNoiThat, CTLoaiPhongNoiThatId> {
//    @Modifying
//    @Query("DELETE FROM ct_loai_phong_noi_that ct WHERE ct.loaiPhong.id = :loaiPhongId")
//    void deleteByLoaiPhongId(Long loaiPhongId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CTLoaiPhongNoiThat ct WHERE ct.loaiPhong.id = :loaiPhongId")
    void deleteByLoaiPhongId(Long loaiPhongId);
}
