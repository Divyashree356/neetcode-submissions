class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    

    for(int h : hand) {
        //duplicates issue
        if(!hm.containsKey(h)) minHeap.add(h);
        hm.put(h, hm.getOrDefault(h, 0)+1);
    }
   
    while(!minHeap.isEmpty()){
        int curMin = minHeap.peek();
        System.out.println(curMin);
        for(int i = curMin; i < curMin + groupSize; i++){
            if(!hm.containsKey(i) || hm.get(i) <= 0) {
                System.out.println(i);
                return false; 
            }
            hm.put(i, hm.get(i)-1);
            if(hm.get(i) == 0) minHeap.remove(i);
        }
    }

    return true;

    }
}