class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
        System.out.println(s);
        char[] f = s.toCharArray();
        int l=f.length;
        for(int i=0;i<l;i++){
            if(f[i]!=f[l-i-1]){
                return false;
            }
        }
        return true;
    }
}
