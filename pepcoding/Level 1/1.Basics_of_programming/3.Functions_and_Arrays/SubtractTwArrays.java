import java.util.Scanner;

public class SubtractTwArrays {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int idx = 0; idx < arr1.length; idx++)
            arr1[idx] = scn.nextInt();

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int idx = 0; idx < arr2.length; idx++)
            arr2[idx] = scn.nextInt();

        subtractTwoArrays(arr1, arr2);
    }

    public static void subtractTwoArrays(int[] arr1, int[] arr2) {
        // arr2>arr1
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int[] res = new int[arr2.length];
        int k = res.length - 1;

        int borrow = 0;
        while (j >= 0) {
            int val = arr2[j] + borrow;
            borrow = 0;

            if (i >= 0) {
                if (val < arr1[i]) {
                    val += 10;
                    borrow = -1;
                }
                val = val - arr1[i];
            }

            res[k--] = val;
            i--;
            j--;
        }


        //remove preciding zeros
        int idx = 0;
        while (idx < res.length) {

            if (res[idx] == 0)
                idx++;
            else
                break;
        }

        // printing from first positive number
        while (idx < res.length)
            System.out.println(res[idx++]);
    }
}
