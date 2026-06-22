class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
     HashMap<String, PriorityQueue<String>> hm = new HashMap<>();   
     List<String> ans = new ArrayList<>();
     
     for(List<String> strs : tickets){
        String from = strs.get(0);
        String to = strs.get(1);

        hm.putIfAbsent(from, new PriorityQueue<>());
        hm.get(from).add(to);
     }

     dfs("JFK", hm, ans);
     Collections.reverse(ans);
     return ans;
     
    }
    public void dfs(String s, HashMap<String, PriorityQueue<String>> hm,  List<String> ans){
        PriorityQueue<String> pq = hm.get(s);
        while ( pq != null &&  !pq.isEmpty()){
            String in = pq.poll();
            dfs(in, hm, ans);
        }
        ans.add(s);
    }

}