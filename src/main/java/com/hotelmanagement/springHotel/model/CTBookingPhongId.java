package com.hotelmanagement.springHotel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CTBookingPhongId implements Serializable {
    private Long booking;
    private Long room;
}
