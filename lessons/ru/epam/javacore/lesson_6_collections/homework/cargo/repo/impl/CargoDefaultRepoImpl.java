package ru.epam.javacore.lesson_6_collections.homework.cargo.repo.impl;

import static ru.epam.javacore.lesson_6_collections.homework.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static ru.epam.javacore.lesson_6_collections.homework.storage.Storage.cargoIndex;
import static ru.epam.javacore.lesson_6_collections.homework.storage.Storage.cargos;
import static ru.epam.javacore.lesson_6_collections.homework.storage.Storage.carriers;

import ru.epam.javacore.lesson_6_collections.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_6_collections.homework.cargo.repo.CargoRepo;
import ru.epam.javacore.lesson_6_collections.homework.common.solutions.utils.ArrayUtils;
import ru.epam.javacore.lesson_6_collections.homework.storage.IdGenerator;

import java.util.Objects;

public class CargoDefaultRepoImpl implements CargoRepo {

  private static final Cargo[] EMPTY_CARGO_ARRAY = new Cargo[0];

  @Override
  public void add(Cargo cargo) {
    if (cargoIndex == cargos.length) {
      Cargo[] newCargos = new Cargo[cargos.length * 2];
      ArrayUtils.copyArray(cargos, newCargos);
      cargos = newCargos;
    }

    cargo.setId(IdGenerator.generateId());
    cargos[cargoIndex] = cargo;
    cargoIndex++;
  }

  @Override
  public Cargo getById(long id) {
    for (Cargo cargo : cargos) {
      if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
        return cargo;
      }
    }

    return null;
  }

  @Override
  public Cargo[] getByName(String name) {
    Cargo[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
    if (searchResultWithNullableElems == null
            || searchResultWithNullableElems.length == 0) {
      return EMPTY_CARGO_ARRAY;
    } else {
      return excludeNullableElementsFromArray(searchResultWithNullableElems);
    }
  }

  private Cargo[] getByNameIncludingNullElements(String name) {
    Cargo[] result = new Cargo[cargos.length];

    int curIndex = 0;
    for (Cargo carrier : cargos) {
      if (carrier != null && Objects.equals(carrier.getName(), name)) {
        result[curIndex++] = carrier;
      }
    }

    return result;
  }

  /**
   * [A,B,C, null, null]
   * [A,B,C, null, null, null, D]
   * [A,B,C]
   *
   * new String[3]
   */
  private Cargo[] excludeNullableElementsFromArray(Cargo[] cargos) {
    int sizeOfArrWithNotNullElems = 0;

    for (Cargo cargo : cargos) {
      if (cargo != null) {
        sizeOfArrWithNotNullElems++;
      }
    }

    if (sizeOfArrWithNotNullElems == 0) {
      return EMPTY_CARGO_ARRAY;
    } else {
      Cargo[] result = new Cargo[sizeOfArrWithNotNullElems];
      int index = 0;
      for (Cargo cargo : cargos) {
        if (cargo != null) {
          result[index++] = cargo;
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
      ArrayUtils.removeElement(cargos, indexToDelete);
      return true;
    }
  }
}
