import java.util.HashSet;
import java.util.Scanner;

public class GetCommonElements1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++)
            arr1[i] = scn.nextInt();

        n = scn.nextInt();
        int[] arr2 = scn.nextInt();
        for (int i = 0; i < n; i++)
            arr2[i] = scn.nextInt();

        // solution -

        HashSet<Integer> hs = new HashSet<>();
        for (int ele : arr1)
            hs.add(ele);

        for (int ele : arr2) {
            if (hs.contains(ele)) {
                System.out.println(ele);
                hs.remove(ele);
            }
        }
    }
}
