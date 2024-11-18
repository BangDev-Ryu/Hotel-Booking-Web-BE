package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.CTLoaiPhongNoiThat;
import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.model.NoiThat;
import com.hotelmanagement.springHotel.repository.CTLoaiPhongNoiThatRepository;
import com.hotelmanagement.springHotel.repository.LoaiPhongRepository;
import com.hotelmanagement.springHotel.repository.NoiThatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTLoaiPhongNoiThatServiceImpl implements CTLoaiPhongNoiThatService {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

    @Autowired
    private NoiThatRepository noiThatRepository;

    @Autowired
    private CTLoaiPhongNoiThatRepository ctLoaiPhongNoiThatRepository;

    @Override
    @Transactional
    public void updateLoaiPhongNoiThat(Long loaiPhongId, List<Long> noiThatIds) {
        LoaiPhong loaiPhong = loaiPhongRepository.findById(loaiPhongId)
                .orElseThrow(() -> new RuntimeException("LoaiPhong not found"));

        // Xóa các NoiThat cũ
        ctLoaiPhongNoiThatRepository.deleteByLoaiPhongId(loaiPhongId);

//        for (CTLoaiPhongNoiThat ctLoaiPhongNoiThat : ctLoaiPhongNoiThatRepository.findAll()) {
//            if (ctLoaiPhongNoiThat.getLoaiPhong().getId().equals(loaiPhongId)) {
//                ctLoaiPhongNoiThatRepository.delete(ctLoaiPhongNoiThat);
//            }
//        }

        // Thêm NoiThat mới
        for (Long noiThatId : noiThatIds) {
            NoiThat noiThat = noiThatRepository.findById(noiThatId)
                    .orElseThrow(() -> new RuntimeException("NoiThat not found"));

            CTLoaiPhongNoiThat ctLoaiPhongNoiThat = new CTLoaiPhongNoiThat();
            ctLoaiPhongNoiThat.setLoaiPhong(loaiPhong);
            ctLoaiPhongNoiThat.setNoiThat(noiThat);
            ctLoaiPhongNoiThatRepository.save(ctLoaiPhongNoiThat);
        }
    }

    @Override
    public List<NoiThat> getNoiThatByLoaiPhong(Long loaiPhongId) {
        return ctLoaiPhongNoiThatRepository.findAll().stream()
                .filter(ct -> ct.getLoaiPhong().getId().equals(loaiPhongId))
                .map(CTLoaiPhongNoiThat::getNoiThat)
                .collect(Collectors.toList());
    }
}
