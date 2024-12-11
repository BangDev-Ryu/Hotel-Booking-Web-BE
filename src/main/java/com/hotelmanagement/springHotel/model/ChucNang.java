package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chuc_nang")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChucNang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String hanhDong;
    private String doiTuong;
}
