class Solution {
    HashMap<Integer, List<Integer>> h;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        h = new HashMap<>();
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> path = new HashSet<Integer>();
        for(int i=0;i<numCourses;i++){
            h.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            h.get(pre[0]).add(pre[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(h.get(i).isEmpty()) continue;
            if(!dfs(path, prerequisites,i,hs)) return false;
        }
        return true;
    }
    public boolean dfs(HashSet<Integer> path, int[][] prq, int i, HashSet<Integer> hs){
        if(hs.contains(i)) return false;
        if(path.contains(i)) return true;
        hs.add(i);
        for(int j : h.get(i)){
            if(!dfs(path,prq,j,hs)) return false;
        }
        hs.remove(i);
        path.add(i);
        return true;
    }
}
