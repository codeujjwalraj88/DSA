import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        // 1. Sequential prefix ka sum
        int sum = nums[0];

        int i = 1;

        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        // 2. Array ke elements HashSet mein store karo
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        // 3. Sum se start karke smallest missing integer find karo
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}