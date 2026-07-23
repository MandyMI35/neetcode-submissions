class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int s=1;
        int k=0;
        int mx = piles[piles.length-1];
        while(s<mx){
            int i=s+(mx-s)/2;
            if(time(piles,i)<=h){
                mx=i;;
            }
            else if(time(piles,i)>h){
                s=i+1;
            }
        }
        return mx;
    }
    public int time(int[] piles, int k){
        int sum=0;
        for(int i: piles){
            if(k!=0){
                sum += i/k;
            }
            if(i<k){
                sum+=1;
            }
            else if(i>k && i%k!=0){
                sum+=1;
            }
        }
        return sum;
    }
}
