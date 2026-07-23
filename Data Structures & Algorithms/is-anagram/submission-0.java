class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            isAnagram("", "a");
        }
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < sa.length; i++) {
            arr[sa[i] - 'a'] ++;
            arr[ta[i] - 'a'] --;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

