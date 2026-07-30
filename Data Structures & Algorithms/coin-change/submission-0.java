class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int mincoins = dfs(amount, coins);
        return mincoins==Integer.MAX_VALUE ? -1 : mincoins;
    }
    public int dfs(int amt, int[] coins){
        if(amt==0) return 0;
        if(memo.containsKey(amt)) return memo.get(amt);
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amt-coin>=0){
                int ress = dfs(amt-coin, coins);
                if (ress!=Integer.MAX_VALUE){
                    res = Math.min(res, 1+ress);
                }
            }
        }
        memo.put(amt, res);
        return res;
    }
}
