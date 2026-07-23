class Solution {
    HashMap<Character, String> h = new HashMap<>();
    List<String> l = new ArrayList<>();
    public List<String> letterCombinations(String digits) { 
        if(digits.length()==0){
            return l;
        }
        h.put('2',"abc");
        h.put('3',"def");
        h.put('4',"ghi");
        h.put('5',"jkl");
        h.put('6',"mno");
        h.put('7',"pqrs");
        h.put('8',"tuv");
        h.put('9',"wxyz");
        rec(digits,0,"");
        return l;
    }
    public void rec(String dig, int idx,String curr){
        if(dig.length()==curr.length()){
            l.add(curr);
            return;
        }
        String s = h.get(dig.charAt(idx));
        for(int j=0;j<s.length();j++){
            rec(dig,idx+1,curr+s.charAt(j));
        }
    }
}
