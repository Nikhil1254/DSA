import java.util.HashMap;

public class l006_lecture6 {

    /**
     * All the questions in this lecture are basically Kadans algo application
     * 
     */
    
    // (IMP) question 1 - Maximum sum Rectangle ()
    // https://www.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    /**
     * 1. follow up - print that rectangle
     */
    int maximumSumRectangle(int n, int m, int matrix[][]) {
        // code here
        int maxVal = Integer.MIN_VALUE ;
        for(int fixedRow=0 ; fixedRow<n ; fixedRow++){
            int[] colPrefixSum = new int[m];
            
            for(int r=fixedRow; r<n ; r++){
                for(int c=0 ; c<m ; c++)
                    colPrefixSum[c] += matrix[r][c]; 
            
                maxVal = Math.max(maxVal,kadansAlgo(colPrefixSum));
            }
            
            
        }
        
        return maxVal;
    }
    
    int kadansAlgo(int[] arr){
        
        int csum = 0, gsum = Integer.MIN_VALUE;
        for(int ele: arr){
            csum  = Math.max(csum+ele,ele);
            gsum = Math.max(csum,gsum);
        }
        
        return gsum;
    }

    // (IMP) - count all subarrays with sum exactyly equals to k
    // https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
    int findSubArraySum(int arr[], int tar)
    {
        // code here
        HashMap<Integer,Integer> hm = new HashMap();
        hm.put(0,1); 
        
        int sum =0 , count =0;
        for(int ele : arr){
            sum+=ele;

            count += hm.getOrDefault(sum-tar,0);    
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        
        return count;
    }


    // question 3 -  Number of Submatrices That Sum to Target
    // https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int n = matrix.length, m = matrix[0].length ;
        int count = 0;
        
        for(int fixedRow=0 ; fixedRow<n ; fixedRow++){
             int[] prefixColSum = new int[m];
             for(int row=fixedRow; row<n ; row++){
                 for(int col=0;col<m;col++)
                     prefixColSum[col] += matrix[row][col];
                 
                 count += findSubArraySum(prefixColSum,target);
             }
        }
        
        return count;
    }

    // question 4 - 


    // question 5 - 
    //
}
