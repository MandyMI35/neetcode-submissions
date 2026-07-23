class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])
        );
        int n=points.length;
        for(int[] point : points){
            pq.add(point);
            if (pq.size()>k){
                pq.poll();
            }
        }
        int[][] result = new int[pq.size()][];
        int index = 0;
        for (int[] element : pq) {
            result[index++] = element;
        }
        return result;
    }
}
