class TimeMap {
    HashMap<String, TreeMap<Integer, String>> h = new HashMap<>();
    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        if(!h.containsKey(key)){
            h.put(key, new TreeMap<>());
        }
        h.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!h.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> m = h.get(key);
        Integer k = m.floorKey(timestamp);
        return k!=null ? m.get(k) :"";
    }
}
