class MyHashSet {
    int[] m;
    public MyHashSet() {
        m = new int[31251];
    }
    
    public void add(int key) {
        m[key/32] |=getMask(key);
    }
    
    public int getMask(int key){
        return 1<<(key%32);
    }
    
    public void remove(int key) {
        if(contains(key)){
            m[key/32]^=getMask(key);
        }
    }

    public boolean contains(int key){
        return (m[key/32] & getMask(key)) != 0;
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */