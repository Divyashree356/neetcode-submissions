class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> hm.get(a) - hm.get(b)
        );

        for (int key : hm.keySet()){
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }
}
