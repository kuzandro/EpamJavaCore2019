package ru.epam.javacore.lesson_24_db_web.homework.storage.initor.multithread;

import ru.epam.javacore.lesson_24_db_web.homework.carrier.domain.Carrier;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils.FileUtils;
import ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils.xml.sax.XmlSaxUtils;
import ru.epam.javacore.lesson_24_db_web.homework.storage.initor.fileinitor.xml.sax.SaxHandler;
import ru.epam.javacore.lesson_24_db_web.homework.storage.initor.fileinitor.xml.sax.XmlSaxFileDataInitor;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.SAXParser;

public class CarrierParser implements Runnable{

  private static final String FILE = "/ru/epam/javacore/lesson_24_db_web/initdata/xmldata.xml";

  private volatile boolean hasError = false;

  private Map<String, Carrier> carrierMap;

  @Override
  public void run() {
    File file = null;
    try {
      file = getFileWithInitData();
      Map<String, Carrier> carrierMap = parseCarriersFromFile(file);
      setCarrierMap(carrierMap);
    } catch (Exception e) {
      e.printStackTrace();
      hasError = true;
    } finally {
      if (file != null) {
        file.delete();
      }
    }
  }

  private Map<String, Carrier> parseCarriersFromFile(File file) throws Exception {
    SAXParser parser = XmlSaxUtils.getParser();
    SaxHandler saxHandler = new SaxHandler();
    parser.parse(file, saxHandler);
    return saxHandler.getCarrierMap();
  }

  private File getFileWithInitData() throws IOException {
    return FileUtils
        .createFileFromResource(
            XmlSaxFileDataInitor.class, "init-data", "lesson", FILE);
  }

  public boolean isHasError() {
    return hasError;
  }

  private synchronized void setCarrierMap(Map<String, Carrier> carrierMap) {
    this.carrierMap = carrierMap;
  }

  public synchronized Map<String, Carrier> getCarrierMap() {
    return this.carrierMap;
  }
}
