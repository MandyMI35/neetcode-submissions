class Solution {
    HashMap<Integer, String> h = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        h.put(2,"abc");
        h.put(3,"def");
        h.put(4,"ghi");
        h.put(5,"jkl");
        h.put(6,"mno");
        h.put(7,"pqrs");
        h.put(8,"tuv");
        h.put(9,"wxyz");
        List<String> l = new ArrayList<>();
        if (digits.length() == 0) {
            return l;
        }
        dfs(digits,0,new StringBuilder(""),l);
        return l;
    }
    public void dfs(String digits, int id, StringBuilder sb,List<String> l){
        if(id==digits.length()){
            l.add(sb.toString());
            return;
        }
        String ite = h.get(digits.charAt(id)-'0');
        for(int i=0;i<ite.length();i++){
            sb.append(ite.charAt(i));
            dfs(digits,id+1,sb,l);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
