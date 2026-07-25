class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, List<Integer>> h = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] ind = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(!h.containsKey(prerequisites[i][0])) h.put(prerequisites[i][0], new ArrayList<>());
            h.get(prerequisites[i][0]).add(prerequisites[i][1]);
            ind[prerequisites[i][1]]++;
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            if(pre(h, new HashSet<>(), queries[i][0], queries[i][1])){
                res.add(true);
            } else { res.add(false);}
        }
        return res;
    }
    public boolean pre(HashMap<Integer, List<Integer>> h, HashSet<Integer> vst, int pnode, int crs){
        Queue<Integer> q = new LinkedList<>();
        q.add(pnode);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(vst.contains(curr)) continue;
            if (curr==crs){return true;}
            vst.add(curr);
            if (!h.containsKey(curr)) continue;
            for(int neig : h.get(curr)){
                q.add(neig);
            }
        }
        return false;
    }
}