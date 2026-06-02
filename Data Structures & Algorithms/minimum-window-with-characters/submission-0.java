class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        int minCount = t.length();
        int left =0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right=0; right < s.length(); right++){

            char c = s.charAt(right);

            if(hm.containsKey(c)){
                if(hm.get(c) > 0) minCount--;
                hm.put(c, hm.get(c)-1);
            }

            while(minCount == 0){
                int len = right - left +1;
                
                if (minLen > len) {
                    minLen = len;
                    start = left;
                }

                char a = s.charAt(left);
                
                if (hm.containsKey(a)){
                    hm.put(a, hm.get(a)+1);
                    if (hm.get(a) > 0) minCount++;
                }

                left++;
            }
        }
        
        if(minLen == Integer.MAX_VALUE)return "";
        return s.substring(start, start + minLen);
    }
}