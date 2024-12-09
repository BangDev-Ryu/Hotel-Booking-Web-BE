package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.CTHoaDon;

import java.util.List;

public interface CTHoaDonService {
    CTHoaDon addServiceToInvoice(Long hoaDonId, Long dichVuId, int quantity);
    List<CTHoaDon> getServicesByInvoiceId(Long hoaDonId);
}
