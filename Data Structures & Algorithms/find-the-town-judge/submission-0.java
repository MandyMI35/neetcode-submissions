class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length < n-1){return -1;}
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<trust.length;i++){
            if(!m.containsKey(trust[i][0])){
                m.put(trust[i][0], -1);
            } 
            else if(m.containsKey(trust[i][0])){
                m.put(trust[i][0], m.get(trust[i][0])-1);
            }
            if(!m.containsKey(trust[i][1])){
                m.put(trust[i][1], +1);
            } 
            else if(m.containsKey(trust[i][1])){
                m.put(trust[i][1], m.get(trust[i][1])+1);
            }
        }
        if (!m.containsValue(n-1)){return -1;}
        for(Map.Entry<Integer, Integer>  e : m.entrySet()){
            if(e.getValue().equals(n-1)){
                return e.getKey();
            }
        }
        return -1;
    }
}