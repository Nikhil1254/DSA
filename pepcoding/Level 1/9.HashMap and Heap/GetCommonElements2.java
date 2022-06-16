import java.util.*;

public class GetCommonElements2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++)
            arr1[i] = scn.nextInt();

        n = scn.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++)
            arr2[i] = scn.nextInt();

        // solution -
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int ele : arr1) {
            if (hm.containsKey(ele))
                hm.put(ele, hm.get(ele) + 1);
            else
                hm.put(ele, 1);
        }

        for (int ele : arr2) {
            if(hm.containsKey(ele) && hm.get(ele)>0){
                System.out.println(ele);
                hm.put(ele, hm.get(ele)-1);
            }
        }
    }
}
