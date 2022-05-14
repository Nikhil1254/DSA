import java.util.Scanner;

public class StairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        for (int jump = 1; jump <= 3 && jump <= n; jump++)
            printStairPaths(n - jump, path + jump);
    }
}
