class Solution {
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        getAllperms(ans, sb, 0, 0, n);
        return ans;
        
    }

    public void getAllperms(List<String> allPerms, StringBuilder str, int open, int close , int n){
        if(str.length() == n*2) {
            allPerms.add(str.toString());
            return;
        }

        if(open < n){
            str.append("(");
            getAllperms(allPerms, str, open+1, close, n);   
            str.deleteCharAt(str.length() -1);
        }
        if(open > close){
            str.append(")");
            getAllperms(allPerms, str, open, close+1, n);   
            str.deleteCharAt(str.length() -1);
        }
    }
}