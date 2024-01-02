public class l002_lecture2 {
    public static void main(String[] args) {
        
    }

    // question 1 - longest substring without repeating characters(leetcode 3)
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // my code -
    public int lengthOfLongestSubstring(String s) {
        int lo = 0 ;
        int maxLen = 0 ;
        int[] visited = new int[128]; // all chars will be in range 0 to 127 ASCII codes 
        
        for(int itr=0 ; itr<s.length() ; itr++){
            char ch = s.charAt(itr);
            
            if(visited[ch]==0){
                visited[ch] = 1;
            }else{
                while(s.charAt(lo)!=ch){
                    visited[s.charAt(lo)] = 0;
                    lo++;
                }
                lo++;    
            }
            maxLen = Math.max(maxLen,itr-lo+1);
        }
        
        return maxLen;
    }

    // sir code - (it's generic template for all such kind of problems)
    public int lengthOfLongestSubstring1(String s) {
        if(s.length()<=1) return s.length();
        
        int n = s.length(), si =0 , ei = 0, count = 0 , len = 0;
        int[] freq = new int[128];
        
        while(ei<n){
            if(freq[s.charAt(ei++)]++ > 0) count++;
            
            while(count > 0)
                if(freq[s.charAt(si++)]-- > 1) count--;
            
            len = Math.max(len,ei-si);
        }
        
        return len;
        /**
         * first do "ei" work, then "si" work if needed and then find length.
         * follow up question - give me longest string itself instead of length
         */
    }


    // question 2 - longest substring with at most K distinct characters - (leetcode 159 - at most 2 distinct characters)
    // (leetcode 340 - longest substring with at most k distinct characters)
    // https://www.codingninjas.com/studio/problems/longest-substring-with-at-most-k-distinct-characters_2221410?leftPanelTabValue=PROBLEM
    public static int kDistinctChars(int k, String str) {
		if(str.length()<=k)return str.length();

		int n = str.length(), si =0 , ei =0 , count = 0, len =0 ;
		int[] freq = new int[128];

		while(ei<n){
			if(freq[str.charAt(ei++)]++ == 0) count++;
		
			while(count>k)
				if(freq[str.charAt(si++)]-- == 1)count--;

			len = Math.max(len,ei-si);
		}

		return len;
	}

    // question 3 - minimum window substring (leetcode 76);
    // https://leetcode.com/problems/minimum-window-substring/
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        
        for(int idx=0 ; idx<t.length() ; idx++)
            freq[t.charAt(idx)]++;
        
        int si = 0 , ei =0 , len = t.length() , ans = Integer.MAX_VALUE;
        int gsi = -1, gei = -1 ;
        
        while(ei<s.length()){
            if(freq[s.charAt(ei++)]-- > 0) len--;
            
            while(len==0){
                if(ei-si<ans){
                    ans = ei-si;
                    gsi = si;
                    gei = ei;
                }
               
                if(freq[s.charAt(si++)]++ == -1) len++;
            }
        }
        
        return gsi!=-1 ? s.substring(gsi,gei) : "";
    }
}
