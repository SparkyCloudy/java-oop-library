package org.library.utils;

import java.io.IOException;

public class ConsoleUtil {

    public static void clear() {
        try {
            var osName = System.getProperty("os.name").toLowerCase();

            if (osName.contains("linux")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

            if (osName.contains("windows")) {
                new ProcessBuilder("cls", "clear").inheritIO().start().waitFor();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
