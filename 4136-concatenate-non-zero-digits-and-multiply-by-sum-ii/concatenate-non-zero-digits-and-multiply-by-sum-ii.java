import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Non-zero digits and their original positions
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                digits.add(c - '0');
                pos.add(i);
            }
        }

        int m = digits.size();

        long[] prefixSum = new long[m + 1];
        long[] prefixNum = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + digits.get(i);
            prefixNum[i + 1] = (prefixNum[i] * 10 + digits.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            long sum = prefixSum[right + 1] - prefixSum[left];

            long number =
                    (prefixNum[right + 1]
                    - (prefixNum[left] * pow10[right - left + 1]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((sum * number) % MOD);
        }

        return ans;
    }

    // first index >= target
    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    // first index > target
    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

/*class Solution {

    public String removeZero(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public int[] sumAndMultiply(String s, int[][] queries) {

        int MOD = 1000000007;
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int start = queries[i][0];
            int end = queries[i][1];

            String sub = s.substring(start, end + 1);

            String nonZero = removeZero(sub);

            if (nonZero.length() == 0) {
                ans[i] = 0;
                continue;
            }

            long number = 0;
            long sum = 0;

            for (int j = 0; j < nonZero.length(); j++) {

                int digit = nonZero.charAt(j) - '0';

                sum += digit;
                number = number * 10 + digit;
            }

            ans[i] = (int)((number * sum) % MOD);
        }

        return ans;
    }
}*/