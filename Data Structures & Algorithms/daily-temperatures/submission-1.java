class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int t = temperatures[i];
            while(!st.isEmpty() && t>st.peek()[1]){
                int[] pair = st.pop();
                res[pair[0]]=i-pair[0];
            }
            st.push(new int[]{i,t});
        }
        return res;
    }
}
