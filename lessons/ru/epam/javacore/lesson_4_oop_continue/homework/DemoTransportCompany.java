package ru.epam.javacore.lesson_4_oop_continue.homework;

import ru.epam.javacore.lesson_4_oop_continue.homework.cargo.Cargo;
import ru.epam.javacore.lesson_4_oop_continue.homework.carrier.Carrier;
import ru.epam.javacore.lesson_4_oop_continue.homework.transportation.Transportation;

public class DemoTransportCompany {
    public static void main(String[] args) {

        Cargo apple = new Cargo();
        apple.setId(1L);
        apple.setName("Apple");

        //storage.addCargo(apple);

        Cargo orrange = new Cargo();
        orrange.setId(2L);
        orrange.setName("Orrange");

        Carrier company_1 = new Carrier();
        company_1.setId(1L);
        company_1.setName("Company 1");


        Transportation transportation = new Transportation();
        transportation.setBillTo("Ivan ivanich");
        transportation.setId(1L);
        transportation.setCargo(apple);
        transportation.setCarrier(company_1);


        apple.setTransportations(
                new Transportation[]{transportation}
        );

    }
}
