package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.LoaiPhong;
import java.util.List;
import java.util.Optional;

public interface LoaiPhongService {
    List<LoaiPhong> getAllLoaiPhong();
    Optional<LoaiPhong> getLoaiPhongById(Long id);
    LoaiPhong saveLoaiPhong(LoaiPhong loaiPhong);
    void deleteLoaiPhong(Long id);
} 