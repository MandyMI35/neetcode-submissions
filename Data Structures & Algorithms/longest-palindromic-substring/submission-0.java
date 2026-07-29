class Solution {
    public String longestPalindrome(String s) {
        int reslen = 0;
        int residx = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > reslen) {
                    residx = l;
                    reslen = r - l + 1;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > reslen) {
                    residx = l;
                    reslen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return s.substring(residx, reslen + residx);
    }
}
