import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int base = scn.nextInt();
        int pow = scn.nextInt();

        System.out.println(powerLinear(base, pow));
    }

    public static int powerLinear(int base, int pow) {
        if (pow == 0)
            return 1;

        return base * powerLinear(base, pow - 1);
    }
}
