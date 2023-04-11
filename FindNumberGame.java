import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class FindNumberGame {

    /*
        Mahir Mammadlee
    */

    static final String _RESET = "\u001B[0m";
    static final String _YELLOW = "\u001B[33m";
    static final String _GREEN = "\u001B[32m";

    public static void main(String[] args) {

        menu();

    }

    //oyunun ana menyusu
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
                        terms();
                        break;
                    case 2:
                        body();
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

    //oyun
    public static void body() {

        //animasiya metodunu yazdır
        System.out.println(progressBar(100));

        System.out.println("-Ai: Ədəd təxmin etmə oyununa xoş gəldiniz..!");

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int min = 0;
        int max = 0;

        while ((max - min) < 400) {
            //[1:200] aralığında təsadüfi minimum ədəd yarat
            min = random.nextInt(400) + 1;

            //[200:500] aralığında təsadüfi maksimum ədəd yarat
            max = random.nextInt(600) + 400;
        }

        //təsadüfi yaradılmış aralıqda təsadüfi ədəd yarat və çap et
        int number = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("-Ai: [" + min + ":" + max + "] aralığında bir ədəd yaradıldı..!");

        //DEMO
        System.out.println(_YELLOW + "{Developer Mode} Təsadüfi ədəd: " + number + _RESET);

        int suppose = 1;          //cari təxmin sayı
        int maxSuppose = 20;      //maksimum təxmin sayı
        boolean isFind = false;   //ədəd tapılıbmı
        int userNumber;           //istifadəçinin təxmin etdiyi ədəd
        int score;                //istifadəçinin qazandığı xal

        while (suppose <= maxSuppose) {

            try {

                //istifadəçi, təxmin etdiyi ədədi daxil edir
                System.out.println("-Ai: " + suppose + ". cəhdiniz. Ədədi təxmin edin: ");
                System.out.print("-Me: ");
                userNumber = sc.nextInt();

                //minimum ədəddən aşağı və maksimum ədəddən yuxarı ədəd daxil edilərsə
                while (userNumber < min || userNumber > max) {

                    System.err.println("-Ai: " + min + " və " + max + " ədədləri aralığında ədəd daxil edə bilərsiniz..!");
                    //DEMO
                    System.out.println(_YELLOW + "{Developer Mode} İstifadə edilmiş təxmin sayı: " + (suppose-1));
                    System.out.println("{Developer Mode} Maksimum təxmin sayı: " + maxSuppose + _RESET);

                    System.out.println("-Ai: " + suppose + ". cəhdiniz. Ədədi təxmin edin.");
                    System.out.print("-Me: ");
                    userNumber = sc.nextInt();
                }

                //istifadəçinin qazanma şərtləri
                if (userNumber == number) {

                    //ədəd tapıldığı halda qazanılan xalın təyini
                    if (suppose <= 5) {
                        score = 100;
                    } else if (suppose <= 10) {
                        score = 50;
                    } else if (suppose <= 15) {
                        score = 25;
                    } else {
                        score = 5;
                    }

                    System.out.println(_GREEN + "-Ai: Təbrik edirik.. Doğru ədəd " + number + " idi");
                    System.out.println("-Ai: " + suppose + ". cəhddə tapdınız.");
                    System.out.println("-Ai: " + score + " xal qazandınız..!" + _RESET);
                    break;

                } else if (userNumber < number && suppose < maxSuppose) {
                    System.out.println("-Ai: Daha böyük ədəd daxil edilməlidir");
                } else if (userNumber > number && suppose < maxSuppose) {
                    System.out.println("-Ai: Daha kiçik ədəd daxil edilməlidir:");
                }
            } catch (InputMismatchException ex) {

                System.err.println("-Ai: Yalnızca ədəd daxil edə bilərsiniz..");

                //next daxil etmədikdə başa qayıdarkən Scanner'i görmür
                sc.next();
                suppose--;
            }

            //DEMO
            System.out.println(_YELLOW + "{Developer Mode} İstifadə edilmiş təxmin sayı: " + suppose);
            System.out.println("{Developer Mode} Maksimum təxmin sayı: " + maxSuppose + _RESET);
            //növbəti təxmin sayı maksimum təxmindən çoxdursa məğlubiyyəti elan et
            if (suppose + 1 > maxSuppose) {

                System.err.println("-Ai: Məğlub oldunuz. " + suppose + " cəhdin heç birində ədədi tapa bilmədiniz.");
                System.err.println("-Ai: Ədəd: " + number + " idi. Bəxtinizi bir daha sınayın..");
            }

            suppose++;
        }

    }

    //qaydalar funksiyası
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
                        body();
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

    //animasiya funksiyası
    public static String progressBar(int progressBarSize) {
        StringBuilder bar = new StringBuilder();
        char pb = '░';
        char stat = '█';
        for (int p = 0; p < progressBarSize; p++) {
            bar.append(pb);
            int ststus = (int) (100 * p / (progressBarSize - 1));
            int move = (progressBarSize * ststus) / 100;
            String progressBar = "[" + bar.substring(0, move).replace(pb, stat) + ststus + "%" + bar.substring(move, bar.length()) + "]";
            System.out.print(progressBar);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\r");
        }
        return "[" + bar.toString().replace(pb, stat) + "100%" + "]";
    }
}
