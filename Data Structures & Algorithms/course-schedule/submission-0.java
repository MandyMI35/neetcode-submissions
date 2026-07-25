class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            l.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        HashSet<Integer> vst = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!dfs(l,vst,i)){return false;}
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> l, HashSet<Integer> vst, int node){
        if(vst.contains(node)){
            return false;
        }
        if(l.get(node).isEmpty()){
            return true;
        }
        vst.add(node);
        for(int neig : l.get(node)){
            if(!dfs(l,vst,neig)) return false;
        }
        vst.remove(node);
        l.get(node).clear();
        return true;
    }
}
