class Solution {
    public int maxArea(int[] heights) {
        int res =0;
        int l=0;
        int r=heights.length-1;
        while(l<r){
            res = Math.max(res, (r-l)*Math.min(heights[r], heights[l]));
            int dif1 =  heights[l+1] - heights[l];
            int dif2 = heights[r-1]-heights[r];
            if(heights[l]>heights[r]) r--;
            else l++;
        }
        return res;
    }
}
