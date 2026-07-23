class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n+1];
        int[] outd = new int[n+1];
        for(int i=0;i<trust.length;i++){
            ind[trust[i][0]]-=1;
            outd[trust[i][1]]+=1;
        }
        for(int i=1;i<n+1;i++){
            if(outd[i]==n-1 && ind[i]==0){return i;}
        }
        return -1;
    }
}