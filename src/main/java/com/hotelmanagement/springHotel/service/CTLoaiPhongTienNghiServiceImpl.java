package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.CTLoaiPhongNoiThat;
import com.hotelmanagement.springHotel.model.CTLoaiPhongTienNghi;
import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.model.TienNghi;
import com.hotelmanagement.springHotel.repository.CTLoaiPhongTienNghiRepository;
import com.hotelmanagement.springHotel.repository.LoaiPhongRepository;
import com.hotelmanagement.springHotel.repository.TienNghiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTLoaiPhongTienNghiServiceImpl implements CTLoaiPhongTienNghiService  {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

    @Autowired
    private TienNghiRepository tienNghiRepository;

    @Autowired
    private CTLoaiPhongTienNghiRepository ctLoaiPhongTienNghiRepository;

    @Override
    @Transactional
    public void updateLoaiPhongTienNghi(Long loaiPhongId, List<Long> tienNghiIds) {
        LoaiPhong loaiPhong = loaiPhongRepository.findById(loaiPhongId)
                .orElseThrow(() -> new RuntimeException("LoaiPhong not found"));

        // Xóa các TienNghi cũ
        ctLoaiPhongTienNghiRepository.deleteByLoaiPhongId(loaiPhongId);
//        for (CTLoaiPhongTienNghi ctLoaiPhongTienNghi : ctLoaiPhongTienNghiRepository.findAll()) {
//            if (ctLoaiPhongTienNghi.getLoaiPhong().getId().equals(loaiPhongId)) {
//                ctLoaiPhongTienNghiRepository.delete(ctLoaiPhongTienNghi);
//            }
//        }

        // Thêm TienNghi mới
        for (Long tienNghiId : tienNghiIds) {
            TienNghi tienNghi = tienNghiRepository.findById(tienNghiId)
                    .orElseThrow(() -> new RuntimeException("TienNghi not found"));

            CTLoaiPhongTienNghi ctLoaiPhongTienNghi = new CTLoaiPhongTienNghi();
            ctLoaiPhongTienNghi.setLoaiPhong(loaiPhong);
            ctLoaiPhongTienNghi.setTienNghi(tienNghi);
            ctLoaiPhongTienNghiRepository.save(ctLoaiPhongTienNghi);
        }
    }

    @Override
    public List<TienNghi> getTienNghiByLoaiPhong(Long loaiPhongId) {
        return ctLoaiPhongTienNghiRepository.findAll().stream()
                .filter(ct -> ct.getLoaiPhong().getId().equals(loaiPhongId))
                .map(CTLoaiPhongTienNghi::getTienNghi)
                .collect(Collectors.toList());
    }
}
