package com.hotelmanagement.springHotel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CTLoaiPhongNoiThatId implements Serializable {
    private Long loaiPhong;
    private Long noiThat;
}
