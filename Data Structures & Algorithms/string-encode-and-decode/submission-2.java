class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder("");
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> l = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int ll = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+ll;
            l.add(str.substring(i,j));
            i=j;
        }
        return l;
    }
}
