class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> mh = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1])
        );
        for(int[] pt : points){
            mh.offer(pt);
            if(mh.size()>k) mh.poll();
        }
        int[][] res = new int[k][2];
        int i=0;
        for(int[] pt : mh){
            res[i][0]=pt[0];
            res[i][1]=pt[1];
            i++;
        }
        return res;
    }
}
