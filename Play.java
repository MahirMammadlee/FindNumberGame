import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Play {

    static final String _RESET = "\u001B[0m";
    static final String _YELLOW = "\u001B[33m";
    static final String _GREEN = "\u001B[32m";

    public static void play() {

        //animasiya metodunu yazdır
        System.out.println(ProgressBar.progressBar(100));

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
}
