class Solution {
    public int minimumDeletions(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_index = 0;
        int min_index = 0;

        // Find min, max and their indexes
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > max) {
                max = nums[i];
                max_index = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                min_index = i;
            }
        }

        int n = nums.length;

        // Case 1: both from left
        int left = Math.max(max_index, min_index) + 1;

        // Case 2: both from right
        int right = n - Math.min(max_index, min_index);

        // Case 3: one from left and one from right
        int both = Math.min(max_index, min_index) + 1
                 + n - Math.max(max_index, min_index);

        return Math.min(left, Math.min(right, both));
    }
}