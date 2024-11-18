package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.NoiThat;

import java.util.List;

public interface CTLoaiPhongNoiThatService {
    void updateLoaiPhongNoiThat(Long loaiPhongId, List<Long> noiThatIds);
    List<NoiThat> getNoiThatByLoaiPhong(Long loaiPhongId);
}
