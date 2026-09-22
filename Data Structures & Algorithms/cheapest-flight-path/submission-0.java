class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prc = new int[n];
        Arrays.fill(prc, Integer.MAX_VALUE);
        prc[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp = Arrays.copyOf(prc,n);
            for(int[] flight : flights){
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if(prc[s]==Integer.MAX_VALUE) continue;
                if(prc[s]+p<temp[d]) temp[d]=prc[s]+p;
            }
            prc = temp;
        }
        return prc[dst]==Integer.MAX_VALUE ? -1 : prc[dst];
    }
}
