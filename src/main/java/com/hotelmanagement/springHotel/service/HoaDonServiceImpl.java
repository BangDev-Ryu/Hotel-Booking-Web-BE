package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.HoaDon;
import com.hotelmanagement.springHotel.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    @Override
    public Optional<HoaDon> getHoaDonById(Long id) {
        return hoaDonRepository.findById(id);
    }

    @Override
    public HoaDon saveHoaDon(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public void deleteHoaDon(Long id) {
        hoaDonRepository.deleteById(id);
    }
}
