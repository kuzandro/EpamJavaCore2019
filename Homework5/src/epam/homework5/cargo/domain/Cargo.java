package epam.homework5.cargo.domain;

import epam.homework5.transportation.domain.Transportation;
import epam.homework5.common.Domain;

import java.util.Arrays;

public class Cargo extends Domain {
    private int weight;
    private CargoType cargoType;
    private Transportation[] transportations;


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }

    public void setTransportations(Transportation[] transportations) {
        this.transportations = transportations;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", weight=" + weight +
                ", cargoType=" + cargoType +
                ", transportations=" + Arrays.toString(transportations) +
                '}';
    }
}