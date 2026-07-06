class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0;
        while(s.length() > i){
            hm.put(s.charAt(i), i);
            i++;
        }

        List<Integer> ans = new ArrayList<>();
        
        i = 0;
        int size = 0;
        int end = 0;


        while(i < s.length()){

            if(end < hm.get(s.charAt(i))) end = hm.get(s.charAt(i));
            size++;

            if(i == end){
                ans.add(size);
                size= 0;
            }

            i++;
        }
        return ans;
    }
}