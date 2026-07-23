class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!s.empty() && temperatures[i]>temperatures[s.peek()]){
                int n = s.pop();
                res[n]=i-n;
            }
            s.push(i);
        }
        return res;
    }
}
