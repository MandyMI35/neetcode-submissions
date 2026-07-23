class Solution {
    public int maxProfit(int[] prices) {
        int m=prices[0];
        int p=0;
        for(int i:prices){
            if(i<m){
                m=i;
            } else {
                p=Math.max(i-m,p);
            }
        }
        return p;
    }
}
