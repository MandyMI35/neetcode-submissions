class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            if (!numset.add(num)) {
                return true; 
            }
        }
        return false;
    }
}
