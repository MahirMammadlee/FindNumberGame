import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {

    static final String _RESET = "\u001B[0m";
    static final String _YELLOW = "\u001B[33m";
    static final String _GREEN = "\u001B[32m";

    public static void menu() {

        while (true) {

            System.out.print(_GREEN + "*********************************************************\n" +
                    "******* Aşağıdakı şərtlərə əsasən rəqəm daxil et ********\n" +
                    "*********************************************************\n" +
                    "1. Oyun qaydaları\n" +
                    "2. Oyuna daxil ol\n" +
                    "0. Oyundan çıx\n" +
                    "*********************************************************\n" +
                    "-Me: " + _RESET);
            Scanner scanner = new Scanner(System.in);

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Terms.terms();
                        break;
                    case 2:
                        Play.play();
                        break;
                    case 0:
                        exit(0);
                        break;
                    default:
                        System.err.println("-Ai: 1, 2 və ya 0 daxil edin..");
                }
            } catch (InputMismatchException execption) {
                System.err.println("-Ai: 1, 2 və ya 0 daxil edin..");
            }

        }
    }
}
