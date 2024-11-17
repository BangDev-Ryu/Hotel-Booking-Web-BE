package com.hotelmanagement.springHotel.repository;

import com.hotelmanagement.springHotel.model.Khu;
import com.hotelmanagement.springHotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // Tìm phòng theo khu
    List<Room> findByKhu(Khu khu);
    
    // Tìm phòng theo số phòng
    Room findBySoPhong(int soPhong);
    
    // Tìm phòng theo loại phòng
    List<Room> findByRoomType(String roomType);
    
    // Tìm phòng theo trạng thái
    List<Room> findByStatus(String status);
    
    // Tìm phòng theo khu và trạng thái
    List<Room> findByKhuAndStatus(Khu khu, String status);
    
    // Tìm phòng có diện tích lớn hơn giá trị cho trước
    List<Room> findByDienTichGreaterThan(double dienTich);
}
