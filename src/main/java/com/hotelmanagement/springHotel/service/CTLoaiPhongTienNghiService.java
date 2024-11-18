package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.TienNghi;

import java.util.List;

public interface CTLoaiPhongTienNghiService {
    void updateLoaiPhongTienNghi(Long loaiPhongId, List<Long> tienNghiIds);
    List<TienNghi> getTienNghiByLoaiPhong(Long loaiPhongId);
}
