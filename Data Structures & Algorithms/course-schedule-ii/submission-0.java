class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges)
            adj.get(e[0]).add(e[1]);

        int[] indegree = new int[V];

        for (List<Integer> ls : adj) {
            for (int i = 0; i < ls.size(); i++)
                indegree[ls.get(i)]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] ans = new int[V];
        int idx = V-1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // ans.add(cur);
            ans[idx--]= cur;
            for (int it : adj.get(cur)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        if(idx == -1) return ans ;
        else {
            int[] emp = new int[0];
            return emp;
        }
    }
}