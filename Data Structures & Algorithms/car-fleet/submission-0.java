class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i =0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        
        }

        Arrays.sort(cars, (a, b)-> b[0]-a[0]);
        int fleets = 0;
        double fleettime = 0;

        for(int i = 0; i < n; i++){
            int pos = cars[i][0];
            int s = cars[i][1];

            double time = (double)(target - pos)/s;
            if(time > fleettime){
                fleettime = time;
                fleets++;
            }
        }
        return fleets;
    }
}