class Solution {
    public int reverse(int x) {
        int res=0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        while(x!=0){
            int dig=x%10;
            if(res>max/10 || res<min/10) return 0;
            if(res==max/10 && dig>max%10) return 0;
            if(res==min/10 && dig<min%10) return 0;
            res=res*10+dig;
            x/=10;
        }
        return res;
    }
}
