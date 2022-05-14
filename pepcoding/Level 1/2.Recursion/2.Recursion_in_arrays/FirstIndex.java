import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        int tar = scn.nextInt();

        System.out.println(firstIndex(arr, 0, tar));
    }

    public static int firstIndex(int[] arr, int idx, int tar) {
        if (idx == arr.length)
            return -1;

        if (tar == arr[idx])
            return idx;

        return firstIndex(arr, idx + 1, tar);
    }
}