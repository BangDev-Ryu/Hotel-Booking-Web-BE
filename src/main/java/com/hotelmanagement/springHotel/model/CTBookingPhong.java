package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ct_booking_phong")
@Setter
@Getter
@IdClass(CTBookingPhongId.class)
@NoArgsConstructor
@AllArgsConstructor
public class CTBookingPhong {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_booking", referencedColumnName = "id_booking")
    private Booking booking;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_phong", referencedColumnName = "id")
    private Room room;
}
