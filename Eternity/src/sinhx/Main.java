package sinhx;

import ui.UIMessages;

import java.util.Scanner;

public class Main {
    /**
     * This is the main method.
     * @param args .
     */
    public static void main(final String[] args) {
        welcomeMessage();
        SinhX sinhFunction = new SinhX();
        try {
            sinhFunction.setup();
            continueApplication(sinhFunction);
        } catch (Exception e) {
            System.out.println(UIMessages.ERROR_MESSAGE_PROGRAM_STOPPED);
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method is to continue the program, if the user chooses 1.
     * exit the program, if the user chooses 0.
     * @param sinhX .
     */
    private static void continueApplication(final SinhX sinhX) {
        while (true) {
            System.out.println("\n" + UIMessages.DOTS + "\n"
                    + UIMessages.OPTIONS_MESSAGE);
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println(UIMessages.INPUT_MESSAGE);
                    sinhX.setup();
                } else if (choice == 0) {
                    System.exit(0);
                } else {
                    System.out.println(UIMessages.ERROR_INVALID_CHOICE);
                }
            } else {
                System.out.println(UIMessages.ERROR_INVALID_CHOICE);
            }
        }
    }

    private static void welcomeMessage() {
        System.out.println(UIMessages.WELCOME_MESSAGE);
        System.out.println(UIMessages.DOTS);
        System.out.println(UIMessages.INPUT_MESSAGE);
    }
}
