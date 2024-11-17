package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "room")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String khu;
    private int soPhong;
    private double dienTich;
    private String roomType;
    private String khuyenMai;
    private String status;
    private BigDecimal price;

}
