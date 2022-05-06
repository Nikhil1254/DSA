import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);

        int n = scn.nextInt() ;
        int[] arr = new int[n];

        for(int i=0 ; i<arr.length ; i++)
            arr[i] = scn.nextInt() ;

        int target = scn.nextInt() ;
        System.out.println(findElementInArray(arr, target));
    }

    public static int findElementInArray(int[] arr,int target){
        int idx = -1 ;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]==target){
                idx=i;
                break ;
            }
        }

        return idx ;
    }
}
