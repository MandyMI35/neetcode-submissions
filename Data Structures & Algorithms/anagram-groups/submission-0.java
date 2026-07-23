class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> f = new ArrayList<>();
        if(strs.length==0 || strs.length==1){
            f.add(new ArrayList<>());
            f.get(0).add(strs[0]);
        }
        Map<String, List<String>> m= new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String d = new String(ch);
            if(!m.containsKey(d)){
                m.put(d, new ArrayList<>());
            }
            m.get(d).add(s);
        }
        return new ArrayList<>(m.values());
    }
    public void anag(String s, String t){
        
    }
}
