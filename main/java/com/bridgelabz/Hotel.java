package com.bridgelabz;

public class Hotel {
    private final String name;
    private final int weekdayRate;
    private final int weekendRate;
    private long totalCost;

    public Hotel(String name, int weekdayRate, int weekendRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getName() {
        return name;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
}