package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "id_khu", referencedColumnName = "id")
    private Khu khu;

    private String name;
    private int dienTich;

    @ManyToOne
    @JoinColumn(name = "id_loai_phong", referencedColumnName = "id")
    private LoaiPhong loaiPhong;

    private String status;
}
