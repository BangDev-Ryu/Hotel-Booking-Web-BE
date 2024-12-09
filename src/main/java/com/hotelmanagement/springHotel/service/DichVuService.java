package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.DichVu;

import java.util.List;
import java.util.Optional;

public interface DichVuService {
    List<DichVu> getAllDichVu();
    Optional<DichVu> getDichVuById(Long id);
    DichVu saveDichVu(DichVu dichVu);
    void deleteDichVu(Long id);
}
