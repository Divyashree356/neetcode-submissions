class MedianFinder {
    List<Integer> nums;
    public MedianFinder() {
        this.nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
        Collections.sort(nums);
    }
    
    public double findMedian() {
        int size = nums.size();
        if(size % 2 == 0){
            int x = size/2-1;
            double med = (double) (nums.get(x) + nums.get(size/2))/2; 
            return med;
        }
        else return (double)nums.get(size/2);
    }
}
