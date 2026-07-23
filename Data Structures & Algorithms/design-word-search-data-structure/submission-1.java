class Tnode{
    Tnode[] children;
    boolean eow;
    public Tnode(){
        children = new Tnode[26];
        eow=false;
    }
}
class WordDictionary {
    Tnode root;
    public WordDictionary() {
        root = new Tnode();
    }

    public void addWord(String word) {
        Tnode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new Tnode();
            }
            curr = curr.children[c-'a'];
        }
        curr.eow=true;
    }

    public boolean search(String word) {
        return dotsearch(word, root, 0);
    }
    public boolean dotsearch(String word, Tnode curr, int i){
        if (i == word.length()) {
            return curr.eow;
        }
        char c = word.charAt(i);
        if(c=='.'){
            for(int j=0;j<26;j++){
                if(curr.children[j]!=null){
                    if(dotsearch(word, curr.children[j], i+1)){
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(curr.children[c-'a']==null){
                return false;
            }
            return dotsearch(word, curr.children[c-'a'],i+1);
        }
    }
}
