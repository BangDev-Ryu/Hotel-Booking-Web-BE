package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Quyen;

import java.util.List;
import java.util.Optional;

public interface QuyenService {
    List<Quyen> getAllQuyen();
    Optional<Quyen> getQuyenById(Long id);
    Quyen saveQuyen(Quyen quyen);
    void deleteQuyen(Long id);
}
