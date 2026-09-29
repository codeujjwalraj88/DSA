class Solution {

    class FenwickTree {
        int n;
        int[] tree;

        FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        // Add value at index
        void update(int index, int value) {
            while (index <= n) {
                tree[index] += value;
                index += index & -index;
            }
        }

        // Sum from 1 to index
        int query(int index) {
            int sum = 0;

            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Prefix sum range:
        // [-n, n]
        // Shift by n + 1 to make it positive
        FenwickTree bit = new FenwickTree(2 * n + 1);

        int sum = n + 1;

        // Empty prefix
        bit.update(sum, 1);

        long ans = 0;

        for (int num : nums) {

            // target = +1
            // non-target = -1
            if (num == target) {
                sum++;
            } else {
                sum--;
            }

            // Previous prefix sums strictly smaller
            // => subarray sum > 0
            ans += bit.query(sum - 1);

            // Store current prefix sum
            bit.update(sum, 1);
        }

        return ans;
    }
}