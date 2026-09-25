class Solution {
    public boolean isHappy(int n) {
        int res=0;
        Set<Integer> h = new HashSet<>();
        while(n!=1){
            n = sq(n);
            if(h.contains(n)) return false;
            h.add(n);
        }
        return true;
    }
    public int sq(int n){
        int r=0;
        while(n!=0){
            r+=Math.pow(n%10,2);
            n/=10;
        }
        return r;
    }
}
