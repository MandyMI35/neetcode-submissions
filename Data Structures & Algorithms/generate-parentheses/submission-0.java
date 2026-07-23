class Solution {
    List<String> l = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String s ="";
        pl(n,s,n);
        return l;
    }
    public void pl(int s,String str,int e){
        if(s==0 && e==0){
            l.add(str);
            return;
        }
        if(s>0){
            pl(s-1,str+'(',e);
        }
        if(e>s){
            pl(s,str+')',e-1);
        }
    }
}
