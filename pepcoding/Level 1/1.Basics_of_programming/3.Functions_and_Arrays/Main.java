import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int idx = 0; idx < arr1.length; idx++)
            arr1[idx] = scn.nextInt();

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < arr2.length; i++)
            arr2[i] = scn.nextInt();

        ArrayList<Integer> res = sortIntersect(arr1, arr2);

        for(int val : res)
            System.out.println(val);
    }

    public static ArrayList<Integer> sortIntersect(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = arr1.length - 1;
        int j = arr2.length - 1;

        ArrayList<Integer> res = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (arr1[i] > arr2[j])
                i--;
            else if (arr1[i] < arr2[j])
                j--;
            else {
                res.add(arr1[i]);
                i--;
                j--;
            }

        }

       
        return  res;

    }
}