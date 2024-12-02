package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hinh_anh")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "longtext")
    private String base64Data;
    
    @Column(name = "loai_phong_id")
    private Long loaiPhongId;
}
