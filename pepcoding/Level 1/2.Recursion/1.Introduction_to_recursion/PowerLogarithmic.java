import java.util.Scanner;

public class PowerLogarithmic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int base = scn.nextInt();
        int pow = scn.nextInt();

        System.out.println(powerLogarithmic(base, pow));
    }

    public static int powerLogarithmic(int base, int pow) {
        if (pow == 0)
            return 1;

        int powNBy2 = powerLogarithmic(base, pow / 2);

        return pow % 2 == 0 ? powNBy2 * powNBy2 : powNBy2 * powNBy2 * base;
    }
}
