import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Terms {

    static final String _RESET = "\u001B[0m";
    static final String _YELLOW = "\u001B[33m";
    static final String _GREEN = "\u001B[32m";

    public static void terms() {

        System.out.println(_GREEN + "*********************************************************\n" +
                "******************** Oyun qaydaları *********************\n" +
                "*********************************************************\n" +
                " 1. Sistem, müeyyen intervalda ədəd seçir. \n" +
                " 2. Siz, o ədədi tapmağa çalışırsınız. \n" +
                " 3. Nə qədər az cəhddə tapsanız o qədər çox xal qazanırsınız. \n\n" +
                " 4. Xallar cədvəli :\n" +
                "    [0-5]   cəhd - 100 Xal\n" +
                "    [6-10]  cəhd - 50  Xal\n" +
                "    [11-15] cəhd - 25  Xal\n" +
                "    [16-20] cəhd - 5   Xal" + _RESET);

        Scanner sc = new Scanner(System.in);
        int i = 0;

        while (i < 1) {
            i++;
            System.out.print(_GREEN + "*********************************************************\n" +
                    "******* Aşağıdakı şərtlərə əsasən rəqəm daxil et ********\n" +
                    "*********************************************************\n" +
                    "1. Oyuna daxil ol\n" +
                    "2. Oyundan çıx\n" +
                    "*********************************************************\n" +
                    "-Me: " + _RESET);

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Play.play();
                        break;
                    case 2:
                        exit(0);
                        break;
                    default:
                        System.err.println("-Ai: 1 və ya 2 daxil edin");
                        i--;
                }
            } catch (InputMismatchException execption) {
                System.err.println("-Ai: 1 və ya 2 daxil edin: ");
                i--;
                sc.next();
            }
        }
    }
}
