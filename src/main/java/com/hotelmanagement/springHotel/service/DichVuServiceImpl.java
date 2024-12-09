package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.DichVu;
import com.hotelmanagement.springHotel.repository.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;

    @Override
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }

    @Override
    public Optional<DichVu> getDichVuById(Long id) {
        return dichVuRepository.findById(id);
    }

    @Override
    public DichVu saveDichVu(DichVu dichVu) {
        return dichVuRepository.save(dichVu);
    }

    @Override
    public void deleteDichVu(Long id) {
        dichVuRepository.deleteById(id);
    }
}
