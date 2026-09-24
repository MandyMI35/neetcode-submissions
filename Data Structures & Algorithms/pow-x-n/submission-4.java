public class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(x==1) return 1;
        double res=1;
        long k = Math.abs((long)n);
        while(k>0){
            if((k & 1)==1) res*=x;
            x*=x;
            k>>=1;
        }
        return n>=0 ? res : 1/res;
    }
}