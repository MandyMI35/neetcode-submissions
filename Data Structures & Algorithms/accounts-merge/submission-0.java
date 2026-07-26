class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if (p1 == p2) return false;
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> eta = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                if (eta.containsKey(email)) {
                    uf.union(i, eta.get(email));
                } else {
                    eta.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailgrp = new HashMap<>();
        for (Map.Entry<String, Integer> entry : eta.entrySet()) {
            String email = entry.getKey();
            int accid = entry.getValue();
            int leader = uf.find(accid);
            emailgrp.putIfAbsent(leader, new ArrayList<>());
            emailgrp.get(leader).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailgrp.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }
}