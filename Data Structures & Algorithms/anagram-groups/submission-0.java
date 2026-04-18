class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>(); 
        for(String s : strs){

            char[] c = s.toCharArray();
            Arrays.sort(c);

            String _s = new String(c);
            
            if (hm.containsKey(_s)) {
                
                List<String >strList = hm.get(_s);
                strList.add(s);
                hm.put(_s, strList);
            }
            else {
            List<String> sub = new ArrayList<>();
            sub.add(s);
            hm.put(_s, sub);
            }
        }
        ans  = new ArrayList<>(hm.values());
        return ans;
    }
}
