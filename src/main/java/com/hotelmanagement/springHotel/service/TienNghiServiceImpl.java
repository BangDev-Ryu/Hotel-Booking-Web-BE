package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.TienNghi;
import com.hotelmanagement.springHotel.repository.TienNghiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TienNghiServiceImpl implements TienNghiService{

    @Autowired
    private TienNghiRepository tienNghiRepository;

    @Override
    public List<TienNghi> getAllTienNghi() {
        return tienNghiRepository.findAll();
    }

    @Override
    public Optional<TienNghi> getTienNghiById(Long id) {
        return tienNghiRepository.findById(id);
    }

    @Override
    public TienNghi saveTienNghi(TienNghi tienNghi) {
        return tienNghiRepository.save(tienNghi);
    }

    @Override
    public void deleteTienNghi(Long id) {
        tienNghiRepository.deleteById((id));
    }
}
