class Solution {
    public boolean isValid(String s) {
        Stack<Character> st1 = new Stack<>();

        for(char c : s.toCharArray()){

            if (c == '(' || c == '[' || c== '{') st1.push(c);
            else 
                if (st1.empty()) return false;
                else {
                    char ch = st1.pop();
                    if((ch == '(' && c != ')') ||
                       (ch == '[' && c != ']') ||
                       (ch == '{' && c != '}')) return false;
                }
        }   
    
        return st1.empty();
        
    }
}