package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, Long> {
}
