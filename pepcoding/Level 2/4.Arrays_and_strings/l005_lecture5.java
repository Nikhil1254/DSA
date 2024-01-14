import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class l005_lecture5 {
    public static void main(String[] args) {

    }

    // question 1 => leetcode 239 - sliding window maximum -
    // https://leetcode.com/problems/sliding-window-maximum/
    /**
     * pq.peek() - O(1)
     * pq.remove() - log(n)
     * pq.add() - log(n)
     */

    // sol1 - using priorityQueue/heap => time complexity worst case -> nlogn
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return nums[b] - nums[a];
        }); // a-b => min priority queue and b-a=> max priority queue

        int n = nums.length, i = 0;
        int[] ans = new int[n - k + 1];
        for (int idx = 0; idx < n; idx++) {

            while (pq.size() != 0 && pq.peek() <= idx - k)
                pq.remove();

            pq.add(idx);

            if (idx >= k - 1)
                ans[i++] = nums[pq.peek()];
        }

        return ans;
    }

    // solution 2 => using deque => time complexity => O(n)
    public int[] maxSlidingWindow1(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        int n = nums.length, idx = 0;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n; i++) { // n
            while (deque.size() != 0 && deque.getFirst() <= i - k)
                deque.removeFirst();

            while (deque.size() != 0 && nums[deque.getLast()] <= nums[i])
                deque.removeLast();

            deque.addLast(i);

            if (i >= k - 1)
                ans[idx++] = nums[deque.getFirst()];
        }

        return ans;
    }

    // question 2 - largest subarray sum => kadans algorithm
    // https://leetcode.com/problems/maximum-subarray/submissions/

    // algo 1 - if all values are negative then also it will give an answer
    public int kadans_generic(int[] nums) {
        int sum = Integer.MIN_VALUE, currSum = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            currSum = Math.max(currSum + nums[idx], nums[idx]);
            sum = Math.max(sum, currSum);
        }

        return sum;
    }

    // algo 2 - if all values are -ve then it will give zero
    public int kadans(int[] nums) {
        int cSum = 0, gSum = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            cSum += nums[idx];

            if (cSum > gSum)
                gSum = cSum;

            if (cSum <= 0)
                cSum = 0;
        }

        return gSum;
    }


    // (Imp)question 3 - K-Concatenation Maximum Sum
    // https://leetcode.com/problems/k-concatenation-maximum-sum/
    int mod = (int) 1e9 + 7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        long preSum = 0, sum = 0 ;
        for(int i=1 ; i<=3 ; i++){
            sum = kadansAlgo(arr,i);
            
            if(k==i)
                return (int) sum;
            
            if(i==3)
                return (int) ((preSum+(k-2)*(sum-preSum))% mod);
                
            preSum = sum ;
        }
        
        return 0;
    }
    
    private int kadansAlgo(int[] arr,int k){
        long csum = 0 , gsum = 0 ;
        int n = arr.length ;
        
        for(int idx=0 ; idx<k*n ; idx++){
            int ele = arr[idx%n];
            csum =((csum + ele)); // dont take mod here cause it can happen csum is greater than gsum but by moding it here can make it less than gsum. and below if condition will not execute and gsum will not update
            
            if(csum>gsum) gsum = csum;
            if(csum<=0) csum = 0;
        }
        
        return (int) gsum%mod;
    }
}
