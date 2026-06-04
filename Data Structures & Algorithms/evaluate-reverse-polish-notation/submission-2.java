class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens){
            System.out.println(st);
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                System.out.println(s);
                int op1 = st.pop();
                int op2 = st.pop();

                if (s.equals("+")) st.push(op2+op1);
                if (s.equals("-")) st.push(op2-op1);
                if (s.equals("*")) st.push(op2*op1);
                if (s.equals("/")) st.push(op2/op1);
            }
            else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}
