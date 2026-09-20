class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res= new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int li=0,cl=0;
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),i);
        }
        for(int i=0;i<s.length();i++){
            cl++;
            li=Math.max(li,hm.get(s.charAt(i)));
            if(i==li){
                res.add(cl);
                cl=0;
            }
        }
        return res;
    }
}
