package com.hotelmanagement.springHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ct_quyen")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CTQuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quyen_id")
    private Quyen quyen;

    @ManyToOne
    @JoinColumn(name = "chuc_nang_id")
    private ChucNang chucNang;
}
