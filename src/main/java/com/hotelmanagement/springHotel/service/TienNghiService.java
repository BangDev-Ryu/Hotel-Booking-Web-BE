package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.TienNghi;
import java.util.List;
import java.util.Optional;

public interface TienNghiService {
    List<TienNghi> getAllTienNghi();
    Optional<TienNghi> getTienNghiById(Long id);
    TienNghi saveTienNghi(TienNghi tienNghi);
    void deleteTienNghi(Long id);
}
