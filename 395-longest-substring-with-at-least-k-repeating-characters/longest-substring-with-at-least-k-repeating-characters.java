 class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;

        // Target number of unique characters
        for (int target = 1; target <= 26; target++) {
            int[] freq = new int[26];

            int left = 0;
            int right = 0;
            int unique = 0;      // Current unique characters
            int atLeastK = 0;    // Characters whose frequency >= k

            while (right < s.length()) {
                int idx = s.charAt(right) - 'a';

                if (freq[idx] == 0) {
                    unique++;
                }

                freq[idx]++;

                if (freq[idx] == k) {
                    atLeastK++;
                }

                right++;

                while (unique > target) {
                    idx = s.charAt(left) - 'a';

                    if (freq[idx] == k) {
                        atLeastK--;
                    }

                    freq[idx]--;

                    if (freq[idx] == 0) {
                        unique--;
                    }

                    left++;
                }

                if (unique == target && unique == atLeastK) {
                    ans = Math.max(ans, right - left);
                }
            }
        }

        return ans;
    }
}