import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length)
            return;

        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }
}
