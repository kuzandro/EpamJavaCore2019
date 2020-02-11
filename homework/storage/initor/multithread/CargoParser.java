package ru.epam.javacore.lesson_24_db_web.homework.storage.initor.multithread;

import ru.epam.javacore.lesson_24_db_web.homework.cargo.domain.Cargo;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils.FileUtils;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils.xml.sax.XmlSaxUtils;
import ru.epam.javacore.lesson_24_db_web.homework.storage.initor.fileinitor.xml.sax.SaxHandler;
import ru.epam.javacore.lesson_24_db_web.homework.storage.initor.fileinitor.xml.sax.XmlSaxFileDataInitor;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.SAXParser;

public class CargoParser implements Runnable {

  private static final String FILE = "/ru/epam/javacore/lesson_24_db_web/initdata/xmldata.xml";

  private volatile boolean hasError = false;

  private Map<String, Cargo> cargoMap;

  @Override
  public void run() {
    File file = null;
    try {
      file = getFileWithInitData();
      Map<String, Cargo> cargoMap = parseCargosFromFile(file);
      setCargoMap(cargoMap);
    } catch (Exception e) {
      e.printStackTrace();
      hasError = true;
    } finally {
      if (file != null) {
        file.delete();
      }
    }
  }

  private Map<String, Cargo> parseCargosFromFile(File file) throws Exception {
    SAXParser parser = XmlSaxUtils.getParser();
    SaxHandler saxHandler = new SaxHandler();
    parser.parse(file, saxHandler);
    return saxHandler.getCargoMap();
  }

  private File getFileWithInitData() throws IOException {
    return FileUtils
        .createFileFromResource(
            XmlSaxFileDataInitor.class, "init-data", "lesson", FILE);
  }

  public boolean isHasError() {
    return hasError;
  }

  private synchronized void setCargoMap(Map<String, Cargo> cargoMap) {
    this.cargoMap = cargoMap;
  }

  public synchronized Map<String, Cargo> getCargoMap() {
    return this.cargoMap;
  }
}
