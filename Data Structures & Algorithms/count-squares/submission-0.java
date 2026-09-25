class CountSquares {
    Map<List<Integer>, Integer> ptscount;
    List<List<Integer>> pts;
    public CountSquares() {
        ptscount = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        pts.add(p);
        ptscount.put(p,ptscount.getOrDefault(p,0)+1);
    }
    
    public int count(int[] point) {
        int res=0;
        int px = point[0], py = point[1];
        for(List<Integer> pt : pts){
            int x=pt.get(0),y=pt.get(1);
            if(Math.abs(y-py)!=Math.abs(x-px) || x==px || y==py) continue;
            res+=ptscount.getOrDefault(Arrays.asList(x,py),0)*
            ptscount.getOrDefault(Arrays.asList(px,y),0);
        }
        return res;
    }
}
