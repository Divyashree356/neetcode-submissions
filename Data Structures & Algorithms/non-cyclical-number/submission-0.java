class Solution {
    public boolean isHappy(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        
        HashSet<Long> hs = new HashSet<>();
        long sq = n;

        while(sq != 1){
            if(hs.contains(sq)) return false;
            hs.add(sq);

            long m = sq;
            sq = 0;

            while(m != 0){
                long cur = m%10;
                sq += cur*cur;
                m = m/10;
            }
        }
        return sq == 1 ? true : false;
    }
}