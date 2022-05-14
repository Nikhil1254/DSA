import java.util.Scanner;

public class PrintZigZag {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printZigZag(n);
    }

    public static void printZigZag(int n) {
        if (n == 1) {
            System.out.print("1 1 1 ");
            return;
        }

        System.out.print(n + " ");
        printZigZag(n - 1);
        System.out.print(n + " ");
        printZigZag(n - 1);
        System.out.print(n + " ");
    }
}
