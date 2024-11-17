package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Room;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAllRooms();
    
    Optional<Room> getRoomById(Long id);
    
    Room saveRoom(Room room);
    
    void deleteRoom(Long id);
}
