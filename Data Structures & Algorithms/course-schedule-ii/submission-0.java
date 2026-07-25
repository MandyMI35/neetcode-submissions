class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            l.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            ind[pre[1]]++;
            l.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        int finish = 0;
        int[] out = new int[numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            out[numCourses - finish - 1] = node;
            finish++;
            for (int neig : l.get(node)) {
                ind[neig]--;
                if (ind[neig] == 0) {
                    q.add(neig);
                }
            }
        }
        if  (finish !=numCourses){
            return new int[0];
        }
        return out;
    }
}
