class Solution {
    public void dfs(int i , List<List<Integer>> adj , boolean[] vis){
        vis[i] = true;
        for(int neigh : adj.get(i)){
            if(vis[neigh] == false){
                dfs(neigh, adj, vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } 
        int count = 0;
        for(int i =0; i < n; i++){
            if(vis[i] == false){
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }
}
