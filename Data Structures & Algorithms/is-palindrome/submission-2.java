class Solution {
    public boolean isPalindrome(String s) {
        
        int i =0;
        int j = s.length() -1;

        
        while(i<j){
        
        char c1 = s.charAt(i);
        c1 = Character.toLowerCase(c1);
        char c2 = s.charAt(j);
        c2 = Character.toLowerCase(c2);

        if (!((c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9'))) {
            i++;
            continue;
        }

        if (!((c2 >= 'a' && c2 <= 'z' ) || (c2 >= '0' && c2 <= '9'))){
            j--;
            continue;
        }

        if (c1 != c2) return false;
        else {
            i++;
            j--;
        }
    }
return true;
}
}