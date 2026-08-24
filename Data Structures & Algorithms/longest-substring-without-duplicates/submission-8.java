class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashSet<Character> h = new HashSet<>();
        int l=0, r=1;
        int fl=1;
        h.add(s.charAt(0));
        while(l<r && r<s.length()){
            if(!h.contains(s.charAt(r))){
                h.add(s.charAt(r));
                r++;
            } else {
                while(h.contains(s.charAt(r))){
                    h.remove(s.charAt(l++));
                }
                h.add(s.charAt(r));
                r++;
            }
            fl = Math.max(fl,r-l);
        }
        return fl;
    }
}
