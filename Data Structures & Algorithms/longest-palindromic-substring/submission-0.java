class Solution {
    public String longestPalindrome(String s) {
        
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            //odd length 
            String odd = getPalLen(i,i, s);
            String even = getPalLen(i,i+1, s);

            String sub = odd.length() > even.length() ? odd  : even;
            if(sub.length() > ans.length()) ans = sub;
        }       
        return ans;
    }

    public String getPalLen(int left, int right, String s){
        int maxLen = 0;
        String str = "";
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            int len = right - left + 1;
            
            if (len > maxLen){
                maxLen = len;
                str = s.substring(left, right+1);
            }

            left--;
            right++;
        }
        return str;
    }
}