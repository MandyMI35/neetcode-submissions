class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(prices,0,true);
    }
    public int dfs(int[] prices, int i, boolean buy){
        if(i>=prices.length) return 0;
        String key = i+"-"+buy;
        if(dp.containsKey(key)) return dp.get(key);
        int cooldown = dfs(prices,i+1,buy);
        if(buy){
            int buyy = dfs(prices,i+1,false)-prices[i];
            dp.put(key,Math.max(cooldown,buyy));
        } else {
            int sell = dfs(prices,i+2,true)+prices[i];
            dp.put(key,Math.max(cooldown,sell));
        }
        return dp.get(key);
    }
}
