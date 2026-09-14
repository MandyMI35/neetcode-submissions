class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dfs(s,wordDict,0,dp);
    }
    public boolean dfs(String s, List<String> wd, int i, Boolean[] dp){
        if(i==s.length()){return true;}
        if(dp[i]!=null) return dp[i];
        for(int j=i+1;j<=s.length();j++){
            if(wd.contains(s.substring(i,j)) && dfs(s,wd,j,dp)){
                dp[i]=true;
                return true;
            }
        }
        return dp[i]=false;
    }
}
