import java.util.Arrays;
import java.util.HashMap;

public class l004_lecture4 {
    public static void main(String[] args) {

    }

    // question 1 - leetcode 904 -
    // https://leetcode.com/problems/fruit-into-baskets/submissions/
    // same as max subarray with at most 2 distinct integers
    // follow up - exactly 2 distinct integers(both basket should have fruits)
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2)
            return fruits.length;

        int si = 0, ei = 0, n = fruits.length, count = 0, len = 0;
        int freq[] = new int[(int) (1e5 + 1)];

        while (ei < n) {
            if (freq[fruits[ei++]]++ == 0)
                count++;

            while (count > 2)
                if (freq[fruits[si++]]-- == 1)
                    count--;

            len = Math.max(len, ei - si);
        }

        return len;
    }

    // question 2 - (leetcode 930)-
    // https://leetcode.com/problems/binary-subarrays-with-sum/
    // same as exactly k subarrays :- atmost(k) - atmost(k-1)
    public int numSubarraysWithSum(int[] nums, int tar) {
        return atMostKOnes(nums, tar) - atMostKOnes(nums, tar - 1);
    }

    private int atMostKOnes(int[] nums, int k) {
        if (k < 0)
            return 0; // all values in nums are positive

        int si = 0, ei = 0, count = 0, ans = 0, n = nums.length;
        while (ei < n) {
            if (nums[ei++] == 1)
                count++;

            while (count > k)
                if (nums[si++] == 1)
                    count--;

            ans += (ei - si);
        }

        return ans;
    }

    // question 3 - (leetcode 485) -
    // https://leetcode.com/problems/max-consecutive-ones/
    /**
     * - we are finding max subarray which contains 1's only
     * we have optimized while loop for si++, directly jumping to ei to remove that
     * zero we got.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int si = 0, ei = 0, n = nums.length, ans = 0;

        while (ei < n) {
            if (nums[ei++] == 0)
                si = ei;

            ans = Math.max(ei - si, ans);
        }

        return ans;
    }

    // question 4 - (leetcode 487 --> lintcode 883) ->
    // https://www.lintcode.com/problem/883/
    public int findMaxConsecutiveOnes2(int[] nums) {
        int n = nums.length, si = 0, ei = 0, count = 0, ans = 0;

        while (ei < n) {
            if (nums[ei++] == 0)
                count++;

            while (count > 1)
                if (nums[si++] == 0)
                    count--;

            ans = Math.max(ans, ei - si);
        }

        return ans;
    }

    // more optimization
    public int findMaxConsecutiveOnes2_1(int[] nums) {
        int n = nums.length, si = 0, ei = 0, ans = 0;
        int firstZeroIdx = -1;
        while (ei < n) {
            if (nums[ei++] == 0) {
                si = firstZeroIdx + 1; // eliminating first zero when we get second one
                firstZeroIdx = ei - 1;
            }

            ans = Math.max(ei - si, ans);
        }

        return ans;
    }

    // question 5 - all subarrays divisible by k(IMP) -
    // https://leetcode.com/problems/subarray-sums-divisible-by-k/
    /**
     * we have 2 follow up questions on this -
     * 1. get all subarrays.=> we need to have arrayList for each index and need to store all indices ,
     * for rem==0 first value will be -1
     * 2. len of longest subarray divisible by k => we just need to store firstIndex
     * and calculate len when next idx comes, cause with first index only it will make largest length
     */

    // get count - using array to implement
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[(int) (1e4 + 1)];
        freq[0] = 1; // to handle rem==0 case
        int sum = 0, ei = 0, count = 0;

        while (ei < n) {
            sum += nums[ei++];
            int rem = (sum % k + k) % k;
            count += (freq[rem]++);
        }

        return count;
    }

    // get longest subarray - using array to implement
    public int longestSubarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[(int) (1e4 + 1)];
        Arrays.fill(freq, -2);
        freq[0] = -1; // to handle rem==0 case
        int sum = 0, ei = 0, len = 0;

        while (ei < n) {
            sum += nums[ei];
            int rem = (sum % k + k) % k;

            if (freq[rem] == -2)
                freq[rem] = ei;
            else
                len = Math.max(len, ei - freq[rem]);
            ei++;
        }

        return len;
    }

    // count all subarrays divisible by k - using hashmap
    public int subarraysDivByK_map(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>(); // remainder vs count hashmap
        hm.put(0, 1); // to handle rem==0 case
        int sum = 0, ei = 0, count = 0;

        while (ei < n) {
            sum += nums[ei++];
            int rem = (sum % k + k) % k;

            count += hm.getOrDefault(rem, 0);
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    // longest subarray divisible by k -> using hashmap
    public int longestSubarraysDivByK_map(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0, ei = 0, len = 0;

        while (ei < n) {
            sum += nums[ei];
            int rem = (sum % k + k) % k;

            hm.putIfAbsent(rem, ei); // storing first index only
            len = Math.max(len, ei - hm.get(rem));
            ei++;
        }

        return len;
    }

    // (IMP)question 6 - subarrays with equal ones and zeros
    // replace 0 by -1 and then same logic as last question(we can use either hm or
    // array to solve)
    // https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // add your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int ei = 0, sum = 0, count = 0;
         while (ei < n) {
            sum += (arr[ei++] == 0 ? -1 : 1);

            count += hm.getOrDefault(sum, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // question 7 - leetcode 525 (followup for last question)
    // https://leetcode.com/problems/contiguous-array/
    // using hashmap
    public int findMaxLength_map(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int ei = 0, sum = 0, len = 0, n = arr.length;

        while (ei < n) {
            sum += (arr[ei] == 0 ? -1 : 1);

            hm.putIfAbsent(sum, ei);
            len = Math.max(len, ei - hm.get(sum));
            ei++;
        }

        return len;
    }

    // using array
    public int findMaxLength_array(int[] arr) {
        int k = (int) (1e5 + 1);
        int[] rem = new int[k];
        Arrays.fill(rem, -2);
        rem[0] = -1;

        int ei = 0, sum = 0, len = 0, n = arr.length;

        while (ei < n) {
            sum += (arr[ei] == 0 ? -1 : 1);
            sum = (sum % k + k) % k;

            if (rem[sum] == -2)
                rem[sum] = ei;

            len = Math.max(len, ei - rem[sum]);
            ei++;
        }

        return len;
    }
}
