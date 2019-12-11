package epam.homework4;

import epam.homework4.cargo.Cargo;
import epam.homework4.carrier.Carrier;
import epam.homework4.transportation.Transportation;

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
