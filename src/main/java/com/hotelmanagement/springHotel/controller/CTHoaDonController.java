package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.CTHoaDon;
import com.hotelmanagement.springHotel.service.CTHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoa-don")
@CrossOrigin
public class CTHoaDonController {

    @Autowired
    private CTHoaDonService ctHoaDonService;

    @PostMapping("/{hoaDonId}/dich-vu/{dichVuId}")
    public ResponseEntity<CTHoaDon> addServiceToInvoice(
            @PathVariable Long hoaDonId,
            @PathVariable Long dichVuId,
            @RequestParam int quantity) {
        CTHoaDon result = ctHoaDonService.addServiceToInvoice(hoaDonId, dichVuId, quantity);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{hoaDonId}/dich-vu")
    public ResponseEntity<List<CTHoaDon>> getServicesByInvoiceId(@PathVariable Long hoaDonId) {
        List<CTHoaDon> services = ctHoaDonService.getServicesByInvoiceId(hoaDonId);
        return ResponseEntity.ok(services);
    }
}
