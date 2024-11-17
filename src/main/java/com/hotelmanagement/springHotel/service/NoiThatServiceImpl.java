package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.NoiThat;
import com.hotelmanagement.springHotel.repository.NoiThatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoiThatServiceImpl implements NoiThatService {

    @Autowired
    private NoiThatRepository noiThatRepository;

    @Override
    public List<NoiThat> getAllNoiThat() {
        return noiThatRepository.findAll();
    }

    @Override
    public Optional<NoiThat> getNoiThatById(Long id) {
        return noiThatRepository.findById(id);
    }

    @Override
    public NoiThat saveNoiThat(NoiThat noiThat) {
        return noiThatRepository.save(noiThat);
    }

    @Override
    public void deleteNoiThat(Long id) {
        noiThatRepository.deleteById(id);
    }
}
