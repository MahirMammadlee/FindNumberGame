public class ProgressBar {

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
