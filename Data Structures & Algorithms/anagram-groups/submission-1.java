class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s : strs){
            int[] id = new int[26];
            for(int i=0;i<s.length();i++){
                id[s.charAt(i)-'a']+=1;
            }
            String ky = Arrays.toString(id);
            hm.putIfAbsent(ky, new ArrayList<>());
            hm.get(ky).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
