class Solution {
    public int minStickers(String[] stickers, String target) {

        int n = target.length();
        int N = 1 << n;

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < N; mask++) {

            if (dp[mask] == Integer.MAX_VALUE)
                continue;

            for (String sticker : stickers) {

                int newMask = mask;

                int[] freq = new int[26];

                for (char c : sticker.toCharArray())
                    freq[c - 'a']++;

                for (int i = 0; i < n; i++) {

                    if (((newMask >> i) & 1) == 1)
                        continue;

                    char ch = target.charAt(i);

                    if (freq[ch - 'a'] > 0) {
                        freq[ch - 'a']--;
                        newMask |= (1 << i);
                    }
                }

                dp[newMask] = Math.min(dp[newMask], dp[mask] + 1);
            }
        }

        return dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1];
    }
}