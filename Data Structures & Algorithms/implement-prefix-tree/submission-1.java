public class Tnode{
    Tnode[] children;
    boolean eow;

    public Tnode(){
        children = new Tnode[26];
        eow=false;
    }
}
class PrefixTree {
    Tnode root;
    public PrefixTree() {
         root = new Tnode();
    }

    public void insert(String word) {
        Tnode curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                curr.children[word.charAt(i)-'a'] = new Tnode();
            }
            curr = curr.children[word.charAt(i)-'a'];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        Tnode curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.children[word.charAt(i)-'a'];
        }
        return curr.eow==true ? true : false;
    }

    public boolean startsWith(String prefix) {
        Tnode curr = root;
        for(int i=0;i<prefix.length();i++){
            if(curr.children[prefix.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
