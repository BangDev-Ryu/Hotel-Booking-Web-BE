package com.hotelmanagement.springHotel.service;

import com.hotelmanagement.springHotel.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> getAllBooking();
    Optional<Booking> getBookingById(Long id);
    Booking saveBooking(Booking booking);
    void deleleBooking(Long id);
}
