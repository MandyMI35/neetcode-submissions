class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        int ol = order.length();
        for(int i=0;i<ol;i++){
            rank[order.charAt(i)-'a']=i;
        }
        ol = words.length;
        for(int i=0;i<ol-1;i++){
            boolean flag = false;
            int len1 = words[i].length(), len2 = words[i+1].length();
            int min = Math.min(len1, len2);
            for(int j=0;j<min;j++){
                char c1 = words[i].charAt(j);
                char c2 = words[i+1].charAt(j);
                if(rank[c1-'a']>rank[c2-'a']){return false;}
                if(rank[c1-'a']<rank[c2-'a']){flag=true;break;} 
           }
           if(!flag && len1>len2){return false;}
        }
        return true;
    }
}