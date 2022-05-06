import java.util.Scanner;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // get arr1
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];

        for (int idx = 0; idx < arr1.length; idx++)
            arr1[idx] = scn.nextInt();

        // get arr2
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for (int idx = 0; idx < arr2.length; idx++)
            arr2[idx] = scn.nextInt();

        getSum(arr1, arr2);
    }

    public static void getSum(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length > arr2.length ? arr1.length : arr2.length];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = res.length - 1;

        int carry = 0;
        while (k >= 0) {
            int val = carry;
            
            if(i>=0)
                val += arr1[i--];

            if(j>=0)
                val+= arr2[j--];

            res[k--] = val%10 ;
            carry = val/10 ; 

        }

        if(carry!=0)
            System.out.println(carry);

        for(int val : res)
            System.out.println(val);
    }
}
