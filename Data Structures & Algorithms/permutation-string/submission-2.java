class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int r = s1.length();
        if (r > s2.length())
            return false;
        int[] f1 = new int[26];
        for (int i = 0; i < r; i++) {
            f1[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i <= s2.length() - r; i++) {
            int[] f2 = new int[26];
            for (int j = i; j < i+r; j++) {
                f2[s2.charAt(j) - 'a'] += 1;
            }
            if(Arrays.equals(f1,f2)) return true;
        }
        return false;
    }
}
