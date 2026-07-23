class KthLargest {
    List<Integer> l ;
    int q;
    public KthLargest(int k, int[] nums) {
        l = new ArrayList<>();
        q=k;
        for (int num : nums) {
            l.add(num);
        }
    }
    
    public int add(int val) {
        l.add(val);
        Collections.sort(l);
        int n=l.size();
        return l.get(n-q);
    }
}
