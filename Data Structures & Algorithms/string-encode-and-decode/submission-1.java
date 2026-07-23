class Solution {
    public String encode(List<String> strs) {
        StringBuilder f = new StringBuilder("");
        for(String s : strs){
            f.append(s.length());
            f.append('#');
            f.append(s);
        }
        System.out.println(f);
        return f.toString();
    }
    public List<String> decode(String str) {
        List<String> f = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j=j+1;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+length;
            f.add(str.substring(i,j));
            i=j;
        }
        return f;
    }
}
