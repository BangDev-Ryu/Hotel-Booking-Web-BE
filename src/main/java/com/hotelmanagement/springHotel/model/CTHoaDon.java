package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ct_hoa_don")
@Setter
@Getter
@IdClass(CTHoaDonId.class)
@NoArgsConstructor
@AllArgsConstructor
public class CTHoaDon {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_hoa_don", referencedColumnName = "id")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_dich_vu", referencedColumnName = "id")
    private DichVu dichVu;

    private int quantity;
    private BigDecimal price;
}
