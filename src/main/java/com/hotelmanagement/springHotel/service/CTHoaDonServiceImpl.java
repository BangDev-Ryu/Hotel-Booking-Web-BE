package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.CTHoaDon;
import com.hotelmanagement.springHotel.model.DichVu;
import com.hotelmanagement.springHotel.model.HoaDon;
import com.hotelmanagement.springHotel.repository.CTHoaDonRepository;
import com.hotelmanagement.springHotel.repository.HoaDonRepository;
import com.hotelmanagement.springHotel.repository.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTHoaDonServiceImpl implements CTHoaDonService {

    @Autowired
    private CTHoaDonRepository ctHoaDonRepository;
    
    @Autowired
    private HoaDonRepository hoaDonRepository;
    
    @Autowired
    private DichVuRepository dichVuRepository;

    @Override
    public CTHoaDon addServiceToInvoice(Long hoaDonId, Long dichVuId, int quantity) {
        HoaDon hoaDon = hoaDonRepository.findById(hoaDonId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));
        
        DichVu dichVu = dichVuRepository.findById(dichVuId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dịch vụ"));
        
        CTHoaDon ctHoaDon = new CTHoaDon();
        ctHoaDon.setHoaDon(hoaDon);
        ctHoaDon.setDichVu(dichVu);
        ctHoaDon.setQuantity(quantity);
        ctHoaDon.setPrice(dichVu.getPrice());
        
        return ctHoaDonRepository.save(ctHoaDon);
    }

    @Override
    public List<CTHoaDon> getServicesByInvoiceId(Long hoaDonId) {
        HoaDon hoaDon = hoaDonRepository.findById(hoaDonId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));
        return ctHoaDonRepository.findByHoaDon(hoaDon);
    }
}
