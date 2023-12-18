public class l001_lecture1 {
    public static void main(String[] args) {
        int[] arr = { 1,0,1,0,0,1,1,0,0 };
        segregateZeroOnes(arr);
        display(arr);
    }

    // question1 - rotate an array by k times +ve means shift front elements to
    // back, -ve means
    // shift back elements to front
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int actualRotations = ((k % n) + n) % n; // actual no of rotations

        if (actualRotations == 0)
            return;

        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, actualRotations - 1);
        reverseArray(nums, actualRotations, n - 1);
    }

    private static void reverseArray(int[] arr, int si, int ei) {
        while (si < ei) {
            swap(arr, si++, ei--);
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // question 2 - segregate +ve and -ve values [+ve values,-ve values]
    private static void segregatePositiveNegative(int[] arr) {
        int ptr1 = 0;

        for (int ptr2 = 0; ptr2 < arr.length; ptr2++) {
            if (arr[ptr2] > 0)
                swap(arr, ptr1++, ptr2);
        }
    }

    private static void display(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    // question 3 - segregate 0,1
    // https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    private static void segregateZeroOnes(int[] arr){
        int ptr1 = 0;

        for (int ptr2 = 0; ptr2 < arr.length; ptr2++) {
            if (arr[ptr2] == 0)
                swap(arr, ptr1++, ptr2);
        }
    }

    // question 4 - segregate 0,1,2 
    // leetcode 75
    private static void segregateZerosOnesTwos(int[] arr){
        int ptr1 = 0, ptr3 = arr.length-1 ;

        for(int ptr2=0 ; ptr2<=ptr3 ; ptr2++){
            int val = arr[ptr2];
            if(val==0)
                swap(arr,ptr1++,ptr2);
            else if(val==2)
                swap(arr,ptr2--,ptr3--);
        }
    }

    //question 5 - max sum configuration
    // https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    // time complexity -  2n
    private static int max_sum(int arr[], int n)
    {
	    int sum = 0 ;
	    int sum1 = 0 ;
	    
	    for(int idx=0 ; idx<n ; idx++){
	        sum += arr[idx];
	        sum1 += (arr[idx]*idx);
	    }
	    
	    int maxSum = sum1 ;
	    for(int idx=0 ; idx<n ; idx++){
	        sum1 = sum1 - sum + (n*arr[idx]);
	        maxSum = Math.max(maxSum,sum1);
	    }
	    
	    return maxSum;
    }
    
    //question 6 - container with most water(leetcode 11)
    // https://leetcode.com/problems/container-with-most-water/
    public static int maxArea(int[] height) {
        int n = height.length ;
        int lp = 0 , rp = n-1;
        
        int maxWater = -1;
        while(lp<rp){
            int area = (rp-lp)*Math.min(height[lp],height[rp]);
            maxWater = Math.max(maxWater,area);
            
            if(height[lp]<height[rp])
                lp++;
            else
                rp--;
        }
        
        return maxWater;
    }

}