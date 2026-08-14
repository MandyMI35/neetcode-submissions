class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pfx = strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(pfx)){
                pfx = pfx.substring(0,pfx.length()-1);
                if(pfx.isEmpty()) return "";
            }
        }
        return pfx;
    }
}