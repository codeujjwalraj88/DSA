import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = word1 me word2[j] ka
        // last possible matching index
        int[] last = new int[m];
        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        // Right se matching
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        boolean changed = false;

        j = 0;

        // Left se greedy selection
        for (i = 0; i < n; i++) {

            // word2 complete ho gaya
            if (j == m) {
                break;
            }

            // Normal matching
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Ek mismatch allowed hai
            else if (!changed &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;

                changed = true;
            }
        }

        // Complete sequence nahi ban payi
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}