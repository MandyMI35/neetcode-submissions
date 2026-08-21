class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> h = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(h.containsKey(target-numbers[i])){
                return new int[]{h.get(target-numbers[i])+1, i+1};
            }
            h.put(numbers[i],i);
        }
        return new int[]{1,1};
    }
}
