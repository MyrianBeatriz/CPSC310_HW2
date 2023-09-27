package edu.trinity;

import java.time.Year;

public class Car {
    private final String make;
    private final String model;
    private final Year year;
    private boolean running;
    private int milesDriven;
    public Car(String make, String model, Year year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.running = false;
        this.milesDriven = 0;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {

        return model;
    }

    public Year getYear() {
        return year;
    }

    public boolean isRunning() {
        return running;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void drive(int distance) {
        if (running) {
            milesDriven += distance;
        }
    }

    public int getMiles() {
        return milesDriven;
    }
}
