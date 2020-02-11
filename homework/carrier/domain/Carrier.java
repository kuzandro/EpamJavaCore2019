package ru.epam.javacore.lesson_24_db_web.homework.carrier.domain;


import ru.epam.javacore.lesson_24_db_web.homework.common.business.domain.BaseEntity;
import ru.epam.javacore.lesson_24_db_web.homework.transportation.domain.Transportation;

import java.util.List;

public class Carrier extends BaseEntity {

  private String name;
  private String address;
  private CarrierType carrierType;
  private List<Transportation> transportations;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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

  public List<Transportation> getTransportations() {
    return transportations;
  }

  public void setTransportations(List<Transportation> transportations) {
    this.transportations = transportations;
  }

  @Override
  public String toString() {
    return "Carrier{" +
        "id='" + id + '\'' +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", carrierType=" + carrierType +
        '}';
  }
}
