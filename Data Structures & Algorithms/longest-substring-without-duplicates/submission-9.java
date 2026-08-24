class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length()==0) return 0;
        HashSet<Character> h = new HashSet<>();
        int l=0, r=0;
        int fl=0;
        while(r<s.length()){
            if(!h.contains(s.charAt(r))){
                h.add(s.charAt(r));
                r++;
                fl=Math.max(fl,r-l);
            } else {
                h.remove(s.charAt(l));
                l++;
            }
        }
        return fl;
    }
}
