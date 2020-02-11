package ru.epam.javacore.lesson_24_db_web.homework.carrier.domain;

import ru.epam.javacore.lesson_24_db_web.homework.transportation.domain.Transportation;

import java.util.List;

public class ProxyCarrier extends Carrier {

  private static final String ERROR_MSG = "Unsupported operation for proxy!";

  public ProxyCarrier() {
  }

  public ProxyCarrier(Long id) {
    this.id = id;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public void setName(String name) {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public String getAddress() {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public void setAddress(String address) {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public CarrierType getCarrierType() {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public void setCarrierType(CarrierType carrierType) {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public List<Transportation> getTransportations() {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public void setTransportations(List<Transportation> transportations) {
    throw new UnsupportedOperationException(ERROR_MSG);
  }

  @Override
  public String toString() {
    return this.id + "";
  }

}
