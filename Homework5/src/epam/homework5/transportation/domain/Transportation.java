package epam.homework5.transportation.domain;

import epam.homework5.cargo.domain.Cargo;
import epam.homework5.carrier.domain.Carrier;

import java.util.Arrays;
import java.util.Date;

public class Transportation {
    private Long id;
    private Cargo cargo;
    private Carrier carrier;
    private String description;
    private String billTo;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        if (cargo != null && carrier != null) {
            return "Transportation{" +
                    "id=" + id +
                    ", Bill to='" + billTo + '\'' +
                    ", Cargo=" + cargo.getName() +
                    ", Carrier=" + carrier.getName() +
                    ", description=" + description +
                    ", date=" + date +
                    '}';
        } else {
            return "Transportation{" +
                    "id=" + id +
                    ", Bill to='" + billTo + '\'' +
                    ", Cargo=" + null +
                    ", Carrier=" + null +
                    ", description=" + description +
                    ", date=" + date +
                    '}';
        }

    }
}