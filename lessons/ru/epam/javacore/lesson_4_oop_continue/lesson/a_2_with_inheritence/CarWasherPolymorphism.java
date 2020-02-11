package ru.epam.javacore.lesson_4_oop_continue.lesson.a_2_with_inheritence;

public class CarWasherPolymorphism {
    public static void main(String[] args) {
        BaseCar truckCar = new TruckCar();
        truckCar.setMarkName("Ural");

        BaseCar passengerCar = new PassengerCar();
        passengerCar.setMarkName("BMW");

        washCar(truckCar);
        System.out.println("----------");
        washCar(passengerCar);
    }

    private static void washCar(BaseCar baseCar) {
        if (baseCar != null) {
            //  System.out.println("Washing  " + baseCar.getMarkName());

            if (baseCar instanceof BaseCar) {
                System.out.println("Give coffee");
            }

            if (TruckCar.class.equals(baseCar.getClass())) {
                System.out.println("Air to wheel");
            }
        }
    }
}
