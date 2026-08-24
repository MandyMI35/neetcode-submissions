class TimeMap {
    Map<String, TreeMap<Integer, String>> m;
    public TimeMap() {
        m=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, k->new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) return "";
        TreeMap<Integer, String> h = m.get(key);
        Map.Entry<Integer, String> e = h.floorEntry(timestamp);
        return e==null ? "" : e.getValue();
    }
}
