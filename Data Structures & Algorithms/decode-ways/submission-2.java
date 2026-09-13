class Solution {
    int res=0;
    int[] dp;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(s,0,0);
    }
    public int dfs(String s, int i, int dpp){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)-'0'<1 || s.charAt(i)-'0'>26) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=0;
        if(s.length()-i>1 && Integer.parseInt(s.substring(i,i+2))>0 && Integer.parseInt(s.substring(i,i+2))<27){
            dp[i]+=dfs(s,i+2,dpp);
        }
        if(s.charAt(i)-'0'>0 && s.charAt(i)-'0'<27){
            dp[i]+=dfs(s,i+1,dpp);
        }
        return dp[i];
    }
}
