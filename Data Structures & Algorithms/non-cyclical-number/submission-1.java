class Solution {
    public boolean isHappy(int n) {
        int slow =n, fast = sq(n);
        while(slow!=fast){
            fast=sq(sq(fast));
            slow=sq(slow);
        }
        return slow==1;
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
