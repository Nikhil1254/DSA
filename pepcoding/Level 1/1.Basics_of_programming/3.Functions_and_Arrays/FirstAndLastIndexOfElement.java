import java.util.Scanner;

public class FirstAndLastIndexOfElement {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scn.nextInt();

        int tar = scn.nextInt();

        System.out.println(getFirstIndex(arr, tar));
        System.out.println(getLastIndex(arr, tar));
    }

    public static int getFirstIndex(int[] arr, int tar) {

        int low = 0 ;
        int high = arr.length-1 ;
        int firstIdx = -1 ;

        while(low<=high){   
            int mid = (low+high)/2 ;
            int val = arr[mid] ;

            if(tar==val){
                high = mid-1 ;
                firstIdx = mid ;
            }else if(tar<val){
                high = mid-1 ;
            }else
                low = mid+1 ;
        }

        return firstIdx ;
    }

    public static int getLastIndex(int[] arr, int tar) {
        int low = 0 ;
        int high = arr.length-1 ;
        int lastIdx = -1 ;

        while(low<=high){   
            int mid = (low+high)/2 ;
            int val = arr[mid] ;

            if(val==tar){
                low = mid+1 ;
                lastIdx = mid ;
            }else if(val>tar){
                high = mid-1 ;
            }else
                low = mid+1 ;
        }

        return lastIdx ;
    }
}
