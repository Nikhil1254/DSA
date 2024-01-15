public class l002_lecture2 {

    // 1. search in sorted matrix 1
    // https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix1(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int si = 0, ei = n * m - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            int r = mid / m;
            int c = mid % m;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return false;
    }

    // 2. search in sorted matrix 2
    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrix2(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int r = 0, c = m - 1;

        while (r < n && c >= 0) {

            if (matrix[r][c] == target)
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }

        return false;
    }

    // (IMP)3. count inversions 
    // https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
    // time complexity -> nlogn+n i.e  O(nlogn), space => O(n) 
    /**
     * 1. we can't use quick sort as it will change elements order at start only
     * 2. we will use merge sort as we will perform sorting in post order so it will not effect our inversions
     * we will calculate inversions first then sort
     */
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here 
        int n = (int)N;
        return mergeSort(arr,0,n-1);
    }
    
    static long mergeSort(long[] arr,int si, int ei){
        if(si>=ei)
            return 0;
            
        int mid = si+(ei-si)/2;
        long leftInversions = mergeSort(arr,si,mid);
        long rightInversions = mergeSort(arr,mid+1,ei);
        
        long acrossInversions = mergeTwoSortedArrays(arr,si,mid,mid+1,ei);
        
        return (leftInversions+rightInversions+acrossInversions);
    }
    
    static long mergeTwoSortedArrays(long[] arr, int si1,int ei1,int si2,int ei2){
        
        long[] temp = new long[ei1-si1+ei2-si2+2];
        
        int ptr1 = si1 , ptr2 = si2, idx = 0 ;
        long count = 0;
        
        
        while(ptr1<=ei1 && ptr2<=ei2){
            
            if(arr[ptr1]>arr[ptr2]){
                count += (ei1-ptr1+1);
                temp[idx++] = arr[ptr2++];
            }else{
                temp[idx++] = arr[ptr1++];
            }
        }
        
        while(ptr1<=ei1)
            temp[idx++] = arr[ptr1++];
            
        while(ptr2<=ei2)
            temp[idx++] = arr[ptr2++];
            
        for(int i=0 ; i<temp.length ; i++)
            arr[si1+i] = temp[i];
            
        return count ;
    }
}