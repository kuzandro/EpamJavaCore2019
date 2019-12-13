package epam.homework5.cargo.domain;

import java.util.Arrays;

public class Computer extends Cargo {
    private String producer;
    private String OS;
    private int SSD;
    private int RAM;
    private int screenSize;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getSSD() {
        return SSD;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", producer='" + producer + '\'' +
                ", OS='" + getOS() + '\'' +
                ", RAM='" + getRAM() + '\'' +
                ", SSD='" + getSSD() + '\'' +
                ", ScreenSize='" + getScreenSize() + '\'' +
                ", transportations=" + Arrays.toString(getTransportations()) +
                '}';
    }
}
