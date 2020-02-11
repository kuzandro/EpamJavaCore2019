package ru.epam.javacore.lesson_6_collections.homework.carrier.repo.impl;

import static ru.epam.javacore.lesson_6_collections.homework.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static ru.epam.javacore.lesson_6_collections.homework.storage.Storage.carrierIndex;
import static ru.epam.javacore.lesson_6_collections.homework.storage.Storage.carriers;

import ru.epam.javacore.lesson_6_collections.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_6_collections.homework.carrier.repo.CarrierRepo;
import ru.epam.javacore.lesson_6_collections.homework.storage.IdGenerator;
import ru.epam.javacore.lesson_6_collections.homework.common.solutions.utils.ArrayUtils;

import java.util.Objects;

public class CarrierDefaultRepoImpl implements CarrierRepo {

  private static final Carrier[] EMPTY_CARRIER_ARRAY = new Carrier[0];

  @Override
  public void add(Carrier carrier) {
    if (carrierIndex == carriers.length) {
      Carrier[] newCarriers = new Carrier[carriers.length * 2];
      ArrayUtils.copyArray(carriers, newCarriers);
      carriers = newCarriers;
    }

    carrier.setId(IdGenerator.generateId());
    carriers[carrierIndex] = carrier;
    carrierIndex++;
  }

  @Override
  public Carrier getById(long id) {
    for (Carrier carrier : carriers) {
      if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
        return carrier;
      }
    }

    return null;
  }

  @Override
  public Carrier[] getByName(String name) {
    Carrier[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
    if (searchResultWithNullableElems == null || searchResultWithNullableElems.length == 0) {
      return EMPTY_CARRIER_ARRAY;
    } else {
      return excludeNullableElementsFromArray(searchResultWithNullableElems);
    }
  }

  private Carrier[] getByNameIncludingNullElements(String name) {
    Carrier[] result = new Carrier[carriers.length];

    int curIndex = 0;
    for (Carrier carrier : carriers) {
      if (carrier != null && Objects.equals(carrier.getName(), name)) {
        result[curIndex++] = carrier;
      }
    }

    return result;
  }


  private Carrier[] excludeNullableElementsFromArray(Carrier[] carriers) {
    int sizeOfArrWithNotNullElems = 0;

    for (Carrier carrier : carriers) {
      if (carrier != null) {
        sizeOfArrWithNotNullElems++;
      }
    }

    if (sizeOfArrWithNotNullElems == 0) {
      return EMPTY_CARRIER_ARRAY;
    } else {
      Carrier[] result = new Carrier[sizeOfArrWithNotNullElems];
      int index = 0;
      for (Carrier carrier : carriers) {
        if (carrier != null) {
          result[index++] = carrier;
        }
      }

      return result;
    }
  }

  @Override
  public boolean deleteById(long id) {
    Integer indexToDelete = findEntityIndexInArrayStorageById(carriers, id);

    if (indexToDelete == null) {
      return false;
    } else {
      ArrayUtils.removeElement(carriers, indexToDelete);
      return true;
    }
  }
}
