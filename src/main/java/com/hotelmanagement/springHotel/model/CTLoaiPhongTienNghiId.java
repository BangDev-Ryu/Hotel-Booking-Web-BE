package com.hotelmanagement.springHotel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CTLoaiPhongTienNghiId implements Serializable {
    private Long loaiPhong;
    private Long tienNghi;
}
