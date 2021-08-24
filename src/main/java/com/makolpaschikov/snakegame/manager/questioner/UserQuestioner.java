package com.makolpaschikov.snakegame.manager.questioner;

import com.makolpaschikov.snakegame.util.ConsoleUtil;

public class UserQuestioner {

    static public void askUserAboutReadiness() {
        ConsoleUtil.print("Are you ready to start (y/n)?: "); // Character 'y' is YES, character 'n' is NO
        String answer = ConsoleUtil.readString();             // User can enter 'y' or 'n' for correct work

        if (!validateUserAnswer(answer)) {
            askUserAboutReadiness();
        }

        if (answer.equals("n")) {
            System.exit(0);
        } else {
            ConsoleUtil.clearConsole();
        }
    }

    static private boolean validateUserAnswer(String answer) {
        if (!answer.equals("y") && !answer.equals("n")) {
            ConsoleUtil.println("Enter 'y' if you are ready, otherwise enter 'n'");
            return false;
        } else {
            return true;
        }
    }

}
