class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        int l=0;
        int r=1;
        int mx=0;
        while(l<r && r<=s.length()){
            Set<Character> cset = new HashSet<>();
            System.out.println(s.substring(l,r));
            for (char c : s.substring(l,r).toCharArray()) {
                cset.add(c);
            }
            System.out.println(cset);
            mx=Math.max(cset.size(), mx);
            if(cset.size()==r-l){
                r+=1;
            } else {
                l+=1;
                r+=1;
            }
        }
        return mx;
    }
}
