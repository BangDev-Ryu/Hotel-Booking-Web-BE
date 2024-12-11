package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.CTQuyen;
import com.hotelmanagement.springHotel.model.ChucNang;
import java.util.List;

public interface CTQuyenService {
    List<CTQuyen> getCTQuyenByQuyenId(Long quyenId);
    List<ChucNang> getChucNangsByQuyenId(Long quyenId);
    CTQuyen saveCTQuyen(CTQuyen ctQuyen);
    void deleteCTQuyen(Long id);
    void capNhatChucNangChoQuyen(Long quyenId, List<Long> chucNangIds);
}