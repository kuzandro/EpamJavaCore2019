package ru.epam.javacore.lesson_4_oop_continue.lesson.a_1_no_inheritence;

public class CarWasher {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMarkName("BMW");
        washPassengerCar(car);

        Truck truck = new Truck();
        truck.setMarkName("KaMaz");
        washTruckCar(truck);
    }

    private static void washPassengerCar(Car car) {
        System.out.println("Wash passenger");
    }

    private static void washTruckCar(Truck truck) {
        System.out.println("Wash truck");
    }
}
