package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.HoaDon;

import java.util.List;
import java.util.Optional;

public interface HoaDonService {
    List<HoaDon> getAllHoaDon();
    Optional<HoaDon> getHoaDonById(Long id);
    HoaDon saveHoaDon(HoaDon hoaDon);
    void deleteHoaDon(Long id);
}
