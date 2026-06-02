class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] n1 = new int[26];
        int[] n2 = new int[26];

        int ns1 = s1.length();
        int ns2 = s2.length();

        if(ns1 > ns2) return false;

        for (int i=0; i <ns1; i++){
            n1[s1.charAt(i)-'a']++;
            n2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(n1,n2))return true;

        for(int i = ns1; i<ns2; i++){
            n2[s2.charAt(i) - 'a']++;
            n2[s2.charAt(i-ns1) - 'a']--;

            if(Arrays.equals(n1,n2))return true;
        }
        return false;
    }
}