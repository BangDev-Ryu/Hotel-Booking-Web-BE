package com.hotelmanagement.springHotel.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChiTietLoaiPhongId implements Serializable {
    private Long loaiPhong;
    private Long noiThat;
    private Long tienNghi;
} 