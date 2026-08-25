class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int r = s1.length();
        if (r > s2.length())
            return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i = 0; i < r; i++) {
            f1[s1.charAt(i) - 'a'] += 1;
            f2[s2.charAt(i) - 'a'] += 1;
        }
        int match=0;
        for(int i=0;i<26;i++){
            if(f1[i]==f2[i]) match++;
        }
        int l=0;
        for(int j=r;j<s2.length();j++){
            if(match==26) return true;

            int ind = s2.charAt(j)-'a';
            f2[ind]++;
            if(f1[ind]==f2[ind]) match++;
            else if(f1[ind]+1 == f2[ind]) match--;

            ind = s2.charAt(l)-'a';
            f2[ind]--;
            if(f1[ind]==f2[ind]) match++;
            else if(f1[ind]-1 == f2[ind]) match--;
            l++;
        }
        return match==26;
    }
}
