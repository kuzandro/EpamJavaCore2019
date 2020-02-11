package ru.epam.javacore.lesson_24_db_web.homework.common.solutions.utils;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtils {

  private FileUtils(){

  }

  public static File createFileFromResource(Class clazz, String fileNamePrefix ,String fileNameSuffix, String resourcePath) throws IOException {
    try(InputStream inputStream = clazz.getResourceAsStream(resourcePath)) {
      Path tempFile = Files.createTempFile(fileNamePrefix, fileNameSuffix);
      Files.copy(inputStream, tempFile, REPLACE_EXISTING);
      return tempFile.toFile();
    }
  }

}
