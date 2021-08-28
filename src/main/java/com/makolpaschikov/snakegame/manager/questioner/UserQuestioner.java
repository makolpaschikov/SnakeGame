package com.makolpaschikov.snakegame.manager.questioner;

import com.makolpaschikov.snakegame.util.ConsoleUtil;

public class UserQuestioner {

    static public void askUserAboutReadiness() {
        ConsoleUtil.clearConsole();
        ConsoleUtil.println("Enter 'y' if you are ready, otherwise enter 'n'\nAre you ready to start (y/n)?: ");
        String answer = ConsoleUtil.readString();

        switch (answer) {
            case "y":
                ConsoleUtil.clearConsole();
                break;
            case "n":
                System.exit(0);
                break;
            default:
                askUserAboutReadiness();
                break;
        }
    }

}
