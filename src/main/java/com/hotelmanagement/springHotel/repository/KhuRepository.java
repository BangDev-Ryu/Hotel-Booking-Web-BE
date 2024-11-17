package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.Khu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuRepository extends JpaRepository<Khu, Long> {

}
