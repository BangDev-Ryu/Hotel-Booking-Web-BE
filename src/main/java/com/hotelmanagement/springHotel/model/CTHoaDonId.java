package com.hotelmanagement.springHotel.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class CTHoaDonId implements Serializable {
    private Long hoaDon;
    private Long dichVu;
}
