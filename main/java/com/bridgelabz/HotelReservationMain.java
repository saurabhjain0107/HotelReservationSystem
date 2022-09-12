package com.bridgelabz;

public class HotelReservationMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System:");
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(new Hotel("Lakewood",110));
        hotelReservation.addHotel(new Hotel("Bridgewood",160));
        hotelReservation.addHotel(new Hotel("Ridgewood",220));
    }
}
