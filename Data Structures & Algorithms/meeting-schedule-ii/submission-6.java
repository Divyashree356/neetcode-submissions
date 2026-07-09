/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start ,b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;
        pq.add(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++){
            if(pq.peek() > intervals.get(i).start){
                pq.add(intervals.get(i).end);
            }
            else{
                pq.poll();
                pq.add(intervals.get(i).end);
            }
            count = Math.max(count, pq.size());
        }
        return count;
    }
}
