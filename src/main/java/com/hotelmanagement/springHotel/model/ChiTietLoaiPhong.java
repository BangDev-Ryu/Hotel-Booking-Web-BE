package com.hotelmanagement.springHotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@Table(name = "chi_tiet_loai_phong")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChiTietLoaiPhongId.class)
public class ChiTietLoaiPhong {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_loai_phong", referencedColumnName = "id")
    private LoaiPhong loaiPhong;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_noi_that", referencedColumnName = "id")
    private NoiThat noiThat;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_tien_nghi", referencedColumnName = "id")
    private TienNghi tienNghi;
}
