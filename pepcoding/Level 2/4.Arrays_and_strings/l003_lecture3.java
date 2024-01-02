public class l003_lecture3 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        System.out.println(allSubarraysWithAtMostK(arr, 2));
    }

    // question 1 - smallest distinct window(find smallest substring which contains
    // all characters of given string at least once)
    // https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    public int findSubString(String s) {
        // Your code goes here
        int[] freq = new int[128];

        int len = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            if (freq[s.charAt(idx)] == 0) {
                freq[s.charAt(idx)]++;
                len++;
            }
        }

        int si = 0, ei = 0, ans = Integer.MAX_VALUE;
        int gsi = -1, gei = -1;

        while (ei < s.length()) {
            if (freq[s.charAt(ei++)]-- > 0)
                len--;

            while (len == 0) {
                ans = Math.min(ei - si, ans);

                if (freq[s.charAt(si++)]++ == 0)
                    len++;
            }
        }

        return ans;
    }

    // question 2 - longest substring with at most K distinct characters(done in lecture 2 itself)


    // question 3 - (leetcode 1456)  Maximum Number of Vowels in a Substring of Given length
    // https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    public int maxVowels(String s, int k) {

        int si = 0, ei = 0, count = 0;
        int maxCount = 0;

        while (ei < s.length()) {
            if (isVowel(s.charAt(ei++)))
                count++;

            if (ei - si == k) {
                maxCount = Math.max(count, maxCount);
                if (isVowel(s.charAt(si++)))
                    count--;
            }
        }

        return maxCount;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // question 4 - longest substring with exactly k distinct characters
    // https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    public int longestkSubstr(String s, int k) {
        if (s.length() < k)
            return -1;

        int si = 0, ei = 0, count = 0, maxLen = -1;
        int[] freq = new int[128];

        while (ei < s.length()) {
            if (freq[s.charAt(ei++)]++ == 0)
                count++;

            while (count > k)
                if (freq[s.charAt(si++)]-- == 1)
                    count--;

            if (count == k)
                maxLen = Math.max(ei - si, maxLen);
        }

        return maxLen;
    }

    // question 5 - count all subarrays with at most k distinct integers(same for
    // strings also we can have)
    public static int allSubarraysWithAtMostK(int[] arr, int k) {
        if (arr.length < k)
            return 0;

        int si = 0, ei = 0, count = 0, subarrayCount = 0;
        int size = (int) (2 * Math.pow(10, 4) + 1);
        int freq[] = new int[size];

        while (ei < arr.length) {
            if (freq[arr[ei++]]++ == 0)
                count++;

            while (count > k)
                if (freq[arr[si++]]-- == 1)
                    count--;

            subarrayCount += (ei - si);
        }

        return subarrayCount;
    }

    // question 6 - count all subarrays with exactly k distinct integers
    // https://leetcode.com/problems/subarrays-with-k-different-integers/
    public int subarraysWithKDistinct(int[] nums, int k) {
        return allSubarraysWithAtMostK(nums, k)-allSubarraysWithAtMostK(nums, k-1);
    }


    // question 7 - Nice subarrays(same as previous one instead of unique character count we need to find all subarray with at most k odd numbers) --> time complexity (4n)
    // https://leetcode.com/problems/count-number-of-nice-subarrays/
    public int numberOfSubarrays(int[] nums, int k) {
        return allSubarraysWithAtMostKOddNumbers(nums,k) - allSubarraysWithAtMostKOddNumbers(nums,k-1);
    }
    
    public  int allSubarraysWithAtMostKOddNumbers(int[] arr, int k) {
        if (arr.length < k)
            return 0;

        int si = 0, ei = 0, count = 0, subarrayCount = 0;

        while (ei < arr.length) {
            if (arr[ei++]%2 != 0) // arr[ei++]&1 != 0  --> using bitwise operator also we can find even odd
                count++;

            while (count > k)
                if (arr[si++]%2 != 0)
                    count--;

            subarrayCount += (ei - si);
        }

        return subarrayCount;

        /**
         * bitwise operation for finding even odd is better than mod operation
         */
    } 
}
