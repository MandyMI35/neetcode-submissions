class Solution {
    HashSet<List<Integer>> s = new HashSet<>();
    int[] cand;
    int t;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        cand=candidates;
        t=target;
        summ(0,new ArrayList<>(), 0);
        List<List<Integer>> res = new ArrayList<>(s);
        return res;
    }
    public void summ(int idx, List<Integer> l, int sum){
        if(sum==t){
            s.add(new ArrayList<>(l));
            return;
        }
        if(sum>t || idx==cand.length){
            return;
        }
        l.add(cand[idx]);
        summ(idx+1,l,sum+cand[idx]);
        l.remove(l.size()-1);
        summ(idx+1,l,sum);
    }
}
