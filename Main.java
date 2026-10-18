import java.util.Random;

public class Main {

    static int minMultiple(int[] arr, int d) {
        int res = Integer.MAX_VALUE;
        for (int v : arr) {
            if (v % d == 0 && v < res) {
                res = v;
            }
        }
        return res;
    }

    static int maxMultiple(int[] arr, int d) {
        int res = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v % d == 0 && v > res) {
                res = v;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] seq = new int[1000];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = random.nextInt(10001);
        }

        int m37 = minMultiple(seq, 37);
        int m73 = maxMultiple(seq, 73);
        int from = m37 < m73 ? m37 : m73;
        int to = m37 < m73 ? m73 : m37;

        int amount = 0;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < seq.length - 1; i++) {
            int inside = 0;
            if (seq[i] > from && seq[i] < to) {
                inside++;
            }
            if (seq[i + 1] > from && seq[i + 1] < to) {
                inside++;
            }
            if (inside == 1) {
                amount++;
                best = Math.min(best, seq[i] + seq[i + 1]);
            }
        }

        System.out.println(amount + " " + best);
    }
}
