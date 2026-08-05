class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0,
            new Integer[triangle.size()][triangle.size()]);
    }
    public int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {
        if (i == triangle.size())
            return 0;
        // if (j == triangle.get(i).size())
        //     return cs;
        if (dp[i][j] != null)
            return dp[i][j];
        dp[i][j] = triangle.get(i).get(j) + Math.min(dfs(triangle, i + 1, j, dp),
            dfs(triangle, i + 1, j + 1, dp));
        return dp[i][j];
    }
}