package com.bridgelabz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservation {
    List<Hotel> hotelList = new ArrayList<>();

    public boolean addHotel(Hotel hotel){
        hotelList.add(hotel);
        return true;
    }
    Hotel getCheapestHotel(String checkInDate, String checkOutDate) {
        int totalReservationDays = CalculateTotalReservationDays(checkInDate, checkOutDate);
        calculateTotalCost(totalReservationDays);
        Hotel cheapestHotel = hotelList.stream().sorted((x, y) -> Integer.compare(x.getTotalCost(), y.getTotalCost())).collect(Collectors.toList()).get(0);
        return cheapestHotel;
    }
    int CalculateTotalReservationDays(String checkInDate, String checkOutDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.valueOf(checkInDate.substring(6, 10)), Integer.valueOf(checkInDate.substring(3, 5)), Integer.valueOf(checkInDate.substring(0, 2)));
        Date date1 = calendar.getTime();
        calendar.set(Integer.valueOf(checkOutDate.substring(6, 10)), Integer.valueOf(checkOutDate.substring(3, 5)), Integer.valueOf(checkOutDate.substring(0, 2)));
        Date date2 = calendar.getTime();
        int totalDays = (int) Math.abs((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
        return totalDays;
    }

    void calculateTotalCost(int totalDays) {
        hotelList.stream().forEach(x -> {
            x.setTotalCost(totalDays * x.getRate());
        });
    }
}

