package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_booking;

    private Long id_account;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private int adult;
    private int children;
    private int totalRoom;
    private String payment;
    private BigDecimal totalPrice;
    private BigDecimal deposit;
    private String status;
}
