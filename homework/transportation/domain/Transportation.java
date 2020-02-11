package ru.epam.javacore.lesson_24_db_web.homework.transportation.domain;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.common.business.domain.BaseEntity;

import java.time.LocalDateTime;
import java.util.Date;

public class Transportation extends BaseEntity {

  private Cargo cargo;
  private Carrier carrier;
  private String description;
  private String billTo;
  private LocalDateTime transportationBeginDate;

  public LocalDateTime getTransportationBeginDate() {
    return transportationBeginDate;
  }

  public void setTransportationBeginDate(LocalDateTime transportationBeginDate) {
    this.transportationBeginDate = transportationBeginDate;
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
    return "Transportation{" +
        "description='" + description + '\'' +
        ", Carrier='" + carrier.getName() + '\'' +
        ", Cargo=" + cargo.getName() +
        '}';
  }
}
