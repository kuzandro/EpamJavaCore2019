package epam.homework5.cargo.domain;

import java.util.Arrays;

public class Phone extends Cargo {
    private String producer;
    private int memory;
    private int screenSize;
    private boolean simLocked;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isSimLocked() {
        return simLocked;
    }

    public void setSimLocked(boolean simLocked) {
        this.simLocked = simLocked;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", producer='" + producer + '\'' +
                ", weight=" + getWeight() +
                ", cargoType=" + getCargoType() +
                ", transportations=" + Arrays.toString(getTransportations()) +
                '}';
    }
}
