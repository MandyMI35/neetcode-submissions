class Solution {
    public int maxArea(int[] heights) {
        int v=0;
        int r=heights.length-1;
        int l=0;
        while(l<r){
            int t=(Math.min(heights[l],heights[r]))*(r-l);
            if(t>v){
                v=t;
            }
            else if (heights[l]>heights[r]){
                r--;
            }
            else {
                l++;
            }
        }
        return v;
    }
}
