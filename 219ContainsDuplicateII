class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> che = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(che.contains(nums[i])) {
                return true;
            } else {
                che.add(nums[i]);
            }

            if(che.size() > k) {
                che.remove(nums[i-k]);
            }
        }
        return false;
    }


}
