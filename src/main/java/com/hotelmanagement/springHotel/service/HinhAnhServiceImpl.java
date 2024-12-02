package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.HinhAnh;
import com.hotelmanagement.springHotel.model.LoaiPhong;
import com.hotelmanagement.springHotel.repository.HinhAnhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {

    @Autowired
    private HinhAnhRepository hinhAnhRepository;
    
    @Autowired
    private LoaiPhongService loaiPhongService;

    @Override
    public List<HinhAnh> getAllHinhAnh() {
        return hinhAnhRepository.findAll();
    }

    @Override
    public Optional<HinhAnh> getHinhAnhById(Long id) {
        return hinhAnhRepository.findById(id);
    }

    @Override
    public HinhAnh createHinhAnh(String base64Data, Long loaiPhongId) {
        LoaiPhong loaiPhong = loaiPhongService.getLoaiPhongById(loaiPhongId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Loại Phòng"));

        HinhAnh hinhAnh = new HinhAnh();
        hinhAnh.setBase64Data(base64Data);
        hinhAnh.setLoaiPhongId(loaiPhongId);
        
        return hinhAnhRepository.save(hinhAnh);
    }

    @Override
    public HinhAnh updateHinhAnh(Long id, String base64Data) {
        HinhAnh hinhAnh = hinhAnhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Hình Ảnh"));
        
        hinhAnh.setBase64Data(base64Data);
        return hinhAnhRepository.save(hinhAnh);
    }

    @Override
    public void deleteHinhAnh(Long id) {
        hinhAnhRepository.deleteById(id);
    }
}
