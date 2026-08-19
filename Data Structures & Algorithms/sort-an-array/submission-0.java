class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return nums;
    }
    public void mergesort(int[] nums, int l, int r){
        if(l>=r) return;
        int mid = (l+r)/2;
        mergesort(nums,l,mid);
        mergesort(nums, mid+1,r);
        merge(nums,l,mid,r);
    }
    public void merge(int[] arr, int l, int m, int r){
        ArrayList<Integer> ll = new ArrayList<>();
        int i=l;
        int j=1+m;
        while(i<=m && j<=r){
            if(arr[i]<=arr[j]){
                ll.add(arr[i]);
                i++;
            } else {
                ll.add(arr[j]);
                j++;
            }
        }
        while(i<=m){
            ll.add(arr[i]);
            i++;
        }
        while(j<=r){
            ll.add(arr[j]);
            j++;
        }
        for(int k=l;k<=r;k++){
            arr[k]=ll.get(k-l);
        }
    }
}