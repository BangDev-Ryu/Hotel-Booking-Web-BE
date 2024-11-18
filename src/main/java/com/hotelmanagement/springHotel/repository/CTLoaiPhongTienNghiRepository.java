package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.CTLoaiPhongTienNghi;
import com.hotelmanagement.springHotel.model.CTLoaiPhongTienNghiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CTLoaiPhongTienNghiRepository extends JpaRepository<CTLoaiPhongTienNghi, CTLoaiPhongTienNghiId> {
//    @Modifying
//    @Query("DELETE FROM ct_loai_phong_tien_nghi ct WHERE ct.loaiPhong.id = :loaiPhongId")
//    void deleteByLoaiPhongId(Long loaiPhongId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CTLoaiPhongTienNghi ct WHERE ct.loaiPhong.id = :loaiPhongId")
    void deleteByLoaiPhongId(Long loaiPhongId);
}
