class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();
        char[] e1=s1.toCharArray();
        Arrays.sort(e1);
        for(int i=0;i<=s2.length()-k;i++){
            char[] e2 = s2.substring(i,i+k).toCharArray();
            Arrays.sort(e2);
            if(Arrays.equals(e1,e2)){
                return true;
            }
        }
        return false;
    }
}