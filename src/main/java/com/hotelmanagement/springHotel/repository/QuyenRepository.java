package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenRepository extends JpaRepository<Quyen, Long> {
}
