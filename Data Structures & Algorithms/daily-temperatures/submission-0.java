class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        int n = t.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < n ; i++){
            
            while(!st.isEmpty() && t[st.peek()] < t[i]){
                int topIndex = st.pop();
                result[topIndex] = i-topIndex;
            }
            st.push(i);
        }

        return result;
    }
}