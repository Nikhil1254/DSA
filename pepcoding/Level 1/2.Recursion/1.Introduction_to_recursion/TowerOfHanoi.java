import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int source = scn.nextInt();
        int dest = scn.nextInt();
        int helper = scn.nextInt();

        toh(n, source, dest, helper);
    }

    public static void toh(int n, int source, int dest, int helper) {
        if (n == 0)
            return;

        toh(n - 1, source, helper, dest);
        System.out.println(n + "[" + source + " -> " + dest + "]");
        toh(n - 1, helper, dest, source);
    }
}
