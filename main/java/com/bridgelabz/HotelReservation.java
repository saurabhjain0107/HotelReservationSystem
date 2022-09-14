package com.bridgelabz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelReservation {
    static Scanner scanner = new Scanner(System.in);
    List<Hotel> hotelList = new ArrayList<>();

    boolean addHotel(Hotel hotel) {
        hotelList.add(hotel);
        return true;
    }
    Hotel getCheapestHotel(String checkInDate, String checkOutDate) {
        LocalDate inDate = LocalDate.of(Integer.valueOf(checkInDate.substring(6, 10)), Integer.valueOf(checkInDate.substring(3, 5)), Integer.valueOf(checkInDate.substring(0, 2)));
        LocalDate outDate = LocalDate.of(Integer.valueOf(checkOutDate.substring(6, 10)), Integer.valueOf(checkOutDate.substring(3, 5)), Integer.valueOf(checkOutDate.substring(0, 2)));

        long totalNumberOfDays = getNumberOfDays(inDate, outDate);
        long weekendDays = getNumberOfWeekendDays(inDate, outDate);
        long weekDays = totalNumberOfDays - weekendDays;

        calculateTotalCost(weekDays, weekendDays);
        Hotel cheapestHotel = hotelList.stream().sorted((x, y) -> Long.compare(x.getTotalCost(), y.getTotalCost())).collect(Collectors.toList()).get(0);
        return cheapestHotel;
    }

    long getNumberOfDays(LocalDate checkInDate, LocalDate checkOutDate) {
        int totalDays = (int) checkInDate.datesUntil(checkOutDate).count();
        return totalDays;
    }

    long getNumberOfWeekendDays(LocalDate checkInDate, LocalDate checkOutDate) {
        Stream<LocalDate> weekendDays = checkInDate.datesUntil(checkOutDate).filter(date -> {
            DayOfWeek day = date.getDayOfWeek();
            boolean isWeekendDay = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
            return isWeekendDay;
        });
        return weekendDays.collect(Collectors.toList()).size();
    }
    void calculateTotalCost(long weekDays, long weekendDays) {
        hotelList.stream().forEach(x -> {
            x.setTotalCost(weekDays * x.getWeekdayRate() + weekendDays * x.getWeekendRate());
        });
    }
}
