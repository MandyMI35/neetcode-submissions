class Solution {
    public int countSubstrings(String s) {
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res.add(l + "," + r);
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res.add(l + "," + r);
                l--;
                r++;
            }
        }
        return res.size();
    }
}
