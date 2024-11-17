package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Khu;
import java.util.List;
import java.util.Optional;

public interface KhuService {
    List<Khu> getAllKhu();
    Optional<Khu> getKhuById(Long id);
    Khu saveKhu(Khu khu);
    void deleteKhu(Long id);
}
