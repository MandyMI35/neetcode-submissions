class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0,true,prices);
    }
    public int dfs(int i, boolean buyn, int[] prc){
        if(i>=prc.length) return 0;
        String key = i+"-"+buyn;
        if(dp.containsKey(key)) return dp.get(key);
        int cd = dfs(i+1,buyn, prc);
        if(buyn){
            int buy = dfs(i+1,false,prc)-prc[i];
            dp.put(key,Math.max(buy,cd));
        } else {
            int sell = dfs(i+2,true,prc)+prc[i];
            dp.put(key,Math.max(sell,cd));
        }
        return dp.get(key);
    }
}
