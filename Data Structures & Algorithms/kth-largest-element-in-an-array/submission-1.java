class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            while(pq.size() > k)pq.poll();
        }
        return (pq.size() > 0 ? pq.peek() : -1);
    }
}
