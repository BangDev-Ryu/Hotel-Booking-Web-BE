package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ct_loai_phong_noi_that")
@Setter
@Getter
@IdClass(CTLoaiPhongNoiThatId.class)
@NoArgsConstructor
@AllArgsConstructor
public class CTLoaiPhongNoiThat {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_loai_phong", referencedColumnName = "id")
    private LoaiPhong loaiPhong;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_noi_that", referencedColumnName = "id")
    private NoiThat noiThat;
}
