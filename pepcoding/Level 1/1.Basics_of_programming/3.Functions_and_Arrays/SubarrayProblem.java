import java.util.Scanner;

public class SubarrayProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        printAllSubArrays(arr);
    }

    public static void printAllSubArrays(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++)
                    System.out.print(arr[k] + "\t");
                System.out.println();
            }
        }
    }
}
