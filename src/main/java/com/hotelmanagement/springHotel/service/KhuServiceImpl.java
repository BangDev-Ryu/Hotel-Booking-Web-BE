package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Khu;
import com.hotelmanagement.springHotel.repository.KhuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuServiceImpl implements KhuService {

    @Autowired
    private KhuRepository khuRepository;

    @Override
    public List<Khu> getAllKhu() {
        return khuRepository.findAll();
    }

    @Override
    public Optional<Khu> getKhuById(Long id) {
        return khuRepository.findById(id);
    }

    @Override
    public Khu saveKhu(Khu khu) {
        return khuRepository.save(khu);
    }

    @Override
    public void deleteKhu(Long id) {
        khuRepository.deleteById(id);
    }
}
