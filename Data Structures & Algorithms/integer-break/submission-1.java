public class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    public int integerBreak(int n) {
        hm.put(1,1);
        return dfs(n, n);
    }

    private int dfs(int num, int original) {
        if(hm.containsKey(num)) return hm.get(num);

        int res = (num == original) ? 0 : num;
        for (int i = 1; i < num; i++) {
            int val = dfs(i, original) * dfs(num - i, original);
            res = Math.max(res, val);
        }
        hm.put(num, res);
        return res;
    }
}