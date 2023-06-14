package org.araragao.shopping.platform.util;

import java.util.Map;

public class StringFormatterUtil {

  public static String formatMap(Map<?, ?> map) {
    StringBuilder stringBuilder = new StringBuilder();

    for (Map.Entry<?, ?> entry : map.entrySet()) {
      stringBuilder.append(entry.getKey()).append(" : ").append(entry.getValue()).append(", ");
    }

    if (!map.isEmpty()) {
      stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    }

    return stringBuilder.toString();
  }
}
