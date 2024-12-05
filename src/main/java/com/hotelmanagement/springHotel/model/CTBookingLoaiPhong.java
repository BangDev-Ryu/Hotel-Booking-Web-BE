package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ct_booking_loai_phong")
@Setter
@Getter
@IdClass(CTBookingLoaiPhong.class)
@NoArgsConstructor
@AllArgsConstructor
public class CTBookingLoaiPhong {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_booking", referencedColumnName = "id_booking")
    private Booking booking;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_loai_phong", referencedColumnName = "id")
    private LoaiPhong loaiPhong;

    private int roomQuantity;
    private BigDecimal price;
}
