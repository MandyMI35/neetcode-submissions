class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        int res=0;
        int l =0, mf=0;
        for(int r=0;r<s.length();r++){
            cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r),0)+1);
            mf = Math.max(mf,cnt.get(s.charAt(r)));
            while((r-l+1)-mf > k){
                cnt.put(s.charAt(l), cnt.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
