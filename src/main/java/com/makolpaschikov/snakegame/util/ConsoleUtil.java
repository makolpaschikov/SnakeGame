package com.makolpaschikov.snakegame.util;

import java.util.Scanner;

public class ConsoleUtil {

    static private final Scanner CONSOLE = new Scanner(System.in);

    static public void print(String val) {
        System.out.print(val);
    }

    static public void println(String val) {
        System.out.println(val);
    }

    static public void printEmptyLine() {
        System.out.println();
    }

    static public String readString() {
        return CONSOLE.nextLine();
    }

    static public void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception ignored) {
            // This exception cannot be thrown
        }
    }
}
