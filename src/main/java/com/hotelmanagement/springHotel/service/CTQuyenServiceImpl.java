package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.CTQuyen;
import com.hotelmanagement.springHotel.model.ChucNang;
import com.hotelmanagement.springHotel.model.Quyen;
import com.hotelmanagement.springHotel.repository.CTQuyenRepository;
import com.hotelmanagement.springHotel.repository.ChucNangRepository;
import com.hotelmanagement.springHotel.repository.QuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTQuyenServiceImpl implements CTQuyenService {
    @Autowired
    private CTQuyenRepository ctQuyenRepository;
    
    @Autowired
    private QuyenRepository quyenRepository;
    
    @Autowired
    private ChucNangRepository chucNangRepository;

    @Override
    public List<CTQuyen> getCTQuyenByQuyenId(Long quyenId) {
        return ctQuyenRepository.findByQuyenId(quyenId);
    }

    @Override
    public CTQuyen saveCTQuyen(CTQuyen ctQuyen) {
        return ctQuyenRepository.save(ctQuyen);
    }

    @Override
    public void deleteCTQuyen(Long id) {
        ctQuyenRepository.deleteById(id);
    }


    @Override
    public List<ChucNang> getChucNangsByQuyenId(Long quyenId) {
        List<CTQuyen> ctQuyens = ctQuyenRepository.findByQuyenId(quyenId);
        return ctQuyens.stream()
                .map(CTQuyen::getChucNang)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void capNhatChucNangChoQuyen(Long quyenId, List<Long> chucNangIds) {
        // Xóa tất cả chi tiết quyền cũ
        ctQuyenRepository.deleteByQuyenId(quyenId);
        
        // Thêm các chi tiết quyền mới
        Quyen quyen = quyenRepository.findById(quyenId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyền"));
                
        chucNangIds.forEach(chucNangId -> {
            ChucNang chucNang = chucNangRepository.findById(chucNangId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy chức năng"));
            
            CTQuyen ctQuyen = new CTQuyen();
            ctQuyen.setQuyen(quyen);
            ctQuyen.setChucNang(chucNang);
            ctQuyenRepository.save(ctQuyen);
        });
    }
} 