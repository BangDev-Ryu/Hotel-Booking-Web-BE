package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.HinhAnh;

import java.util.List;
import java.util.Optional;

public interface HinhAnhService {
    List<HinhAnh> getAllHinhAnh();
    Optional<HinhAnh> getHinhAnhById(Long id);
    HinhAnh createHinhAnh(String base64Data, Long loaiPhongId);
    HinhAnh updateHinhAnh(Long id, String base64Data);
    void deleteHinhAnh(Long id);
}
