package epam.homework5.carrier.domain;

import epam.homework5.transportation.domain.Transportation;
import epam.homework5.common.Domain;

import java.util.Arrays;

public class Carrier extends Domain {
    private String address;
    private CarrierType carrierType;
    private Transportation[] transportations;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CarrierType getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(CarrierType carrierType) {
        this.carrierType = carrierType;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }

    public void setTransportations(Transportation[] transportations) {
        this.transportations = transportations;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", adress=" + address +
                ", carrierType=" + carrierType +
                ", transportations=" + Arrays.toString(transportations) +
                '}';
    }
}