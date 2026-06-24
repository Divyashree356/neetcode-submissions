class Solution {
    int count;
    public int countSubstrings(String s) {
        count = 0;
        for(int i =0; i<s.length(); i++){
            checkPal(i, i, s);
            checkPal(i, i+1, s);
        }    
        return count;
    }
    public void checkPal(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
    }

}