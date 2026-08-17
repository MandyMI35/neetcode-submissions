class MyHashSet {
    boolean[] m;
    public MyHashSet() {
        m = new boolean[1000001];
    }
    
    public void add(int key) {
        m[key]=true;
    }
    
    public void remove(int key) {
        m[key]=false;
    }
    
    public boolean contains(int key) {
        return m[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */