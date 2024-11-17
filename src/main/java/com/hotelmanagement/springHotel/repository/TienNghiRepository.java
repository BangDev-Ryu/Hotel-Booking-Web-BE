package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.TienNghi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TienNghiRepository extends JpaRepository<TienNghi, Long> {
}
