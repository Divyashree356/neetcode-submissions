class Solution {
    public boolean dfs(int parent, int node, boolean[] vis, List<List<Integer>> adj){
        vis[node] = true;
        for(int neigh : adj.get(node)){

            if(vis[neigh] == false){ 
                if(dfs(node, neigh, vis, adj) == true) return true;
            }
            else if(neigh != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++)adj.add(new ArrayList<>());
        for (int[]e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        if(dfs(-1, 0, vis, adj) == true) {
            // System.out.println("here");
            return false;
        }

        for(int i = 0; i < n; i++){
            if(vis[i] == false) return false;
        }

        return true;
    }
}
