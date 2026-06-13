class Solution {
    static class Pair{
        int[] p;
        double min;

        public Pair(int[] arr, double _min){
            this.p = arr;
            this.min = _min;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.min , a.min));

        for(int[] point : points){
            int x = point[0];
            int y = point[1];

            double eul = Math.sqrt((x*x) + (y*y));
            pq.add(new Pair(new int[]{x,y}, eul));
            while(pq.size() > k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(pq.size() != 0){
            Pair pt = pq.poll();
            ans[i++] = pt.p; 
        }
        return ans;
    }
}