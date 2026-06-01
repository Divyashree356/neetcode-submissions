class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==1 || n==0)return n;

        String sub = s.substring(0,1);
        int ans= 0;

        int i = 1;
        while(i<n){
            char c = s.charAt(i);
            int idx = sub.indexOf(c);
            if (idx == -1) sub = sub + c;
            else {
                ans = Math.max(ans, sub.length());
                sub = sub.substring(idx+1, sub.length()) + c;
            }
            i++;
        }
return Math.max(ans, sub.length());
    }
}