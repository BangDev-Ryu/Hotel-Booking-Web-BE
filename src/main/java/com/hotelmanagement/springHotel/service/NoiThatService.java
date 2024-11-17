package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.NoiThat;
import java.util.List;
import java.util.Optional;

public interface NoiThatService {
    List<NoiThat> getAllNoiThat();
    Optional<NoiThat> getNoiThatById(Long id);
    NoiThat saveNoiThat(NoiThat noiThat);
    void deleteNoiThat(Long id);
}
