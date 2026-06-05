class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int area = Integer.MIN_VALUE;
        int n = heights.length;

        for(int i = 0; i <n; i++){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){

                int curr = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;

                area = Math.max(area, heights[curr] * (nse-pse-1));
            } st.push(i);
        }

        System.out.println(st);
        while(!st.isEmpty()){
            int nse = n;
            int curr = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            area = Math.max(area, heights[curr] * (nse-pse-1));
        }

        return area;
    }
}