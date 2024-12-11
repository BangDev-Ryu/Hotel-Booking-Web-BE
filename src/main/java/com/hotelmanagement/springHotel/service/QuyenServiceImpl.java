package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Quyen;
import com.hotelmanagement.springHotel.repository.QuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuyenServiceImpl implements QuyenService {

    @Autowired
    private QuyenRepository quyenRepository;

    @Override
    public List<Quyen> getAllQuyen() {
        return quyenRepository.findAll();
    }

    @Override
    public Optional<Quyen> getQuyenById(Long id) {
        return quyenRepository.findById(id);
    }

    @Override
    public Quyen saveQuyen(Quyen quyen) {
        return quyenRepository.save(quyen);
    }

    @Override
    public void deleteQuyen(Long id) {
        quyenRepository.deleteById(id);
    }
}
