class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitions(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void partitions(String s, List<List<String>> ans, List<String> subs, int part) {
        if (part == s.length())
            ans.add(new ArrayList<>(subs));
        for (int i = part; i < s.length(); i++) {
            if (isPalindrome(part, i, s)) {
                String sub = s.substring(part, i + 1);
                subs.add(sub);
                partitions(s, ans, subs, i + 1);
                subs.remove(subs.size() - 1);
            }
            // else System.out.println("always false");
        }
    }

    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }
}