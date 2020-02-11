package ru.epam.javacore.lesson_4_oop_continue.lesson.a_2_with_inheritence;

public class PassengerCar extends BaseCar {
    private int passengerNumber;

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }
}
