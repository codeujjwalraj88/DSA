import java.util.*;

class Solution {
    // Digit to prime factors count (2, 3, 5, 7)
    private static final int[][] DIGIT_FACTORS = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t into 2, 3, 5, 7
        int[] reqPrimes = new int[4]; // 2, 3, 5, 7
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                reqPrimes[i]++;
                t /= primes[i];
            }
        }
        if (t > 1) return "-1"; // Prime factor outside 2,3,5,7

        int n = num.length();

        // Check if num itself is valid (no zeros and satisfies t)
        int firstZero = num.indexOf('0');
        if (firstZero == -1) {
            int[] currentPrimes = getPrimesFromString(num);
            if (isSatisfied(currentPrimes, reqPrimes)) {
                return num;
            }
        }

        // Calculate prefix primes up to each index
        int[] prefixPrimes = getPrimesFromString(num);

        // Step 2: Try to find the smallest number of SAME LENGTH
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';

            // Remove digit i's factors from prefix
            subtractFactors(prefixPrimes, DIGIT_FACTORS[d]);

            // If we are beyond the first zero, we can't change digits before it
            if (firstZero != -1 && i > firstZero) {
                continue;
            }

            int spaceAfter = n - 1 - i;

            // Try placing a bigger digit at position i
            for (int bigger = d + 1; bigger <= 9; bigger++) {
                int[] remNeeded = getRemainingNeeded(reqPrimes, prefixPrimes);
                subtractFactors(remNeeded, DIGIT_FACTORS[bigger]);

                int[] digitsReq = convertPrimesToDigits(remNeeded);
                int totalDigitsReq = sumArray(digitsReq);

                if (totalDigitsReq <= spaceAfter) {
                    // Valid! Build result
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(bigger);

                    int fillOnes = spaceAfter - totalDigitsReq;
                    for (int k = 0; k < fillOnes; k++) {
                        sb.append('1');
                    }
                    appendDigits(sb, digitsReq);
                    return sb.toString();
                }
            }
        }

        // Step 3: If same length fails, increase length to (n + 1 or more)
        int[] minDigitsReq = convertPrimesToDigits(reqPrimes);
        int totalMinDigits = sumArray(minDigitsReq);
        int targetLen = Math.max(n + 1, totalMinDigits);

        StringBuilder sb = new StringBuilder();
        int onesToFill = targetLen - totalMinDigits;
        for (int i = 0; i < onesToFill; i++) {
            sb.append('1');
        }
        appendDigits(sb, minDigitsReq);

        return sb.toString();
    }

    // Converts remaining (2, 3, 5, 7) prime counts into minimal DIGIT counts (2..9)
    private int[] convertPrimesToDigits(int[] primes) {
        int c2 = Math.max(0, primes[0]);
        int c3 = Math.max(0, primes[1]);
        int c5 = Math.max(0, primes[2]);
        int c7 = Math.max(0, primes[3]);

        int[] digits = new int[10];

        // 8 = 2^3
        digits[8] = c2 / 3;
        c2 %= 3;

        // 9 = 3^2
        digits[9] = c3 / 2;
        c3 %= 2;

        // 4 = 2^2
        digits[4] = c2 / 2;
        c2 %= 2;

        digits[2] = c2;
        digits[3] = c3;
        digits[5] = c5;
        digits[7] = c7;

        // Optimization: combine 2 and 3 into 6 if both left
        if (digits[2] > 0 && digits[3] > 0) {
            digits[2]--;
            digits[3]--;
            digits[6]++;
        }

        // Optimization: combine 4 and 3 into 2 and 6
        if (digits[4] > 0 && digits[3] > 0) {
            digits[4]--;
            digits[3]--;
            digits[2]++;
            digits[6]++;
        }

        return digits;
    }

    private int[] getPrimesFromString(String s) {
        int[] res = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '1' && ch <= '9') {
                int d = ch - '0';
                for (int j = 0; j < 4; j++) {
                    res[j] += DIGIT_FACTORS[d][j];
                }
            }
        }
        return res;
    }

    private void subtractFactors(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            a[i] = Math.max(0, a[i] - b[i]);
        }
    }

    private int[] getRemainingNeeded(int[] req, int[] current) {
        int[] rem = new int[4];
        for (int i = 0; i < 4; i++) {
            rem[i] = Math.max(0, req[i] - current[i]);
        }
        return rem;
    }

    private boolean isSatisfied(int[] current, int[] req) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < req[i]) return false;
        }
        return true;
    }

    private int sumArray(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    private void appendDigits(StringBuilder sb, int[] digits) {
        for (int d = 2; d <= 9; d++) {
            for (int k = 0; k < digits[d]; k++) {
                sb.append(d);
            }
        }
    }
}