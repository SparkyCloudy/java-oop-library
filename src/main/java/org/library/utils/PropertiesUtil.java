package org.library.utils;

import org.library.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

  private static final Properties properties = new Properties();

  private static final InputStream is = Main.class
      .getResourceAsStream("/application.properties");

  public static void init() {
    try {
      PropertiesUtil.properties
          .load(PropertiesUtil.is);

    } catch (IOException e) {
      System.out.printf("Error: %s\n", e.getMessage());
    }
  }

  public static String get(String key) {
    if (PropertiesUtil.properties.isEmpty()) {
      return "PropertiesUtil not yet initialiazed, please run PropertiesUtil" +
          ".init() function before using this function\n";
    }

    return PropertiesUtil.properties.getProperty(key);
  }
}
