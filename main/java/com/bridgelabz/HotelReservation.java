package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    List<Hotel> hotelList = new ArrayList<>();

    public boolean addHotel(Hotel hotel){
        hotelList.add(hotel);
        return true;
    }
}
