class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for(char c: tasks){
            freq[c -'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : freq){
            if(i>0) pq.add(i);
        }

        int ans = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            int task = 0;
            List<Integer> left= new ArrayList<>();

            while(cycle > 0 && !pq.isEmpty()){
                int cur = pq.poll();
                task++;
                if(cur > 1) {
                    left.add(cur-1);
                }
                cycle--;
            }
            
            for(int ele : left) pq.add(ele);
            ans += pq.isEmpty() ? task : n+1;
        }
    return ans;
    }
}