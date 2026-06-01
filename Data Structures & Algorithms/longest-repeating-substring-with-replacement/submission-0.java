class Solution {
    public int characterReplacement(String s, int k) {

        if(s.length() == 1) return 1;

        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int maxFreq = 0;
        int maxLen = 0;

        int end = 0;

        while(end < s.length()){
            char c = s.charAt(end);
            hm.put(c, hm.getOrDefault(c, 0)+1);
            maxFreq = Math.max(maxFreq, hm.get(c));
            //lenght - maxFreq is the number which else we can replace 
            if(end-start+1 - maxFreq >k){
                char ch = s.charAt(start);
                hm.put(ch, hm.get(ch) -1);
                start++;
            }
            
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }       
        return maxLen;
    }
}