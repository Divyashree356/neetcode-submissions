class Solution {
    HashMap<Character, String> hm;

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        getComb(digits, 0, ans, new StringBuilder());
        return ans;
    }

    public void getComb(String digits, int idx, List<String> ans, StringBuilder sb) {
        if (idx == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String curStr = hm.get(ch);
        for (char c : curStr.toCharArray()) {
            sb.append(c);
            getComb(digits, idx + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}