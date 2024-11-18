package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ct_loai_phong_tien_nghi")
@Setter
@Getter
@IdClass(CTLoaiPhongTienNghiId.class)
@NoArgsConstructor
@AllArgsConstructor
public class CTLoaiPhongTienNghi {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_loai_phong", referencedColumnName = "id")
    private LoaiPhong loaiPhong;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_tien_nghi", referencedColumnName = "id")
    private TienNghi tienNghi;
}
