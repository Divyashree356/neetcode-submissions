class Solution {
    public boolean dfs(int[][] prerequisites, int i , boolean[] vis, boolean[] pathVis){
        vis[i] = true;
        pathVis[i] = true;

        for(int[] pre : prerequisites){
            if(pre[0] == i && vis[pre[1]] == false){
                if(dfs(prerequisites, pre[1], vis, pathVis) == true) return true;
            }

            else if(pre[0] == i && pathVis[pre[1]] == true) return true;
        }
        pathVis[i] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(vis[i] == false){
                if(dfs(prerequisites, i, vis, pathVis) == true) return false;
            }
        }
        return true;
    }
}