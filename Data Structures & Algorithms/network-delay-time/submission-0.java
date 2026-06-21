class Solution {
    class Pair{
        int node;
        int dist;
        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int wt = t[2];

            adj.get(u).add(new int[]{v, wt});
        } 

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        int minTime = -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist - b.dist
        );

        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int wt = pq.peek().dist;
            pq.poll();

            for(int i = 0; i < adj.get(node).size(); i++){
                int[] newNodeConfig = adj.get(node).get(i);
                int newNode = newNodeConfig[0];
                int newNodeWt = newNodeConfig[1];

                if(wt + newNodeWt < dist[newNode]){
                    dist[newNode] = wt + newNodeWt;
                    pq.add(new Pair(newNode, wt + newNodeWt));
                }
            }
        }

        for(int i =1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            else {
                minTime = Math.max(minTime, dist[i]);
            }
        }
        return minTime;

    }
}
