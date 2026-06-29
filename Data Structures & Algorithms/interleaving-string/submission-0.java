class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] vis = new Boolean[s1.length()+1][s2.length()+2];
        return checkInter(s1, s2, s3, 0, 0, 0, vis);
    }

    public boolean checkInter(String s1, String s2, String s3, int i, int j, int k, Boolean[][] vis){
        if(k == s3.length()) return true;
        if(vis[i][j] != null) return vis[i][j];

        boolean valid = i < s1.length() && (s1.charAt(i) == s3.charAt(k) && checkInter(s1, s2, s3, i+1,j,k+1, vis)) ||
        (j < s2.length() && (s2.charAt(j) == s3.charAt(k) && checkInter(s1, s2, s3, i,j+1,k+1, vis)));

        return vis[i][j] = valid;
    }
}