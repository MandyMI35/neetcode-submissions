class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int res=0;
        for(int p : prices){
            res = Math.max(res, p-min);
            min = Math.min(min,p);
        }
        return res;
    }
}
