package com.hotelmanagement.springHotel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CTBookingLoaiPhongId implements Serializable {
    private Long booking;
    private Long loaiPhong;
}
