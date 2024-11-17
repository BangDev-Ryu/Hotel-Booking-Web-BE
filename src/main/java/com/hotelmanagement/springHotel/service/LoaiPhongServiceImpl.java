package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.repository.LoaiPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiPhongServiceImpl implements LoaiPhongService {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

    @Override
    public List<LoaiPhong> getAllLoaiPhong() {
        return loaiPhongRepository.findAll();
    }

    @Override
    public Optional<LoaiPhong> getLoaiPhongById(Long id) {
        return loaiPhongRepository.findById(id);
    }

    @Override
    public LoaiPhong saveLoaiPhong(LoaiPhong loaiPhong) {
        return loaiPhongRepository.save(loaiPhong);
    }

    @Override
    public void deleteLoaiPhong(Long id) {
        loaiPhongRepository.deleteById(id);
    }
} 