import java.util.Scanner;

public class SubsetsOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scn.nextInt();

        printSubsets(arr, n);
    }

    public static void printSubsets(int[] arr, int n) {
        int limit = (int) Math.pow(2, n); // no of subsets we have
        for (int i = 0; i < limit; i++) {
            String str = "";
            int temp = i;
            for (int j = n - 1; j >= 0; j--) {
                int r = temp % 2;
                temp /= 2;

                if (r == 1)
                    str = arr[j] + "\t" + str;
                else
                    str = "-\t" + str;
            }

            System.out.println(str);
        }
    }
}
