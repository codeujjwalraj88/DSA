import java.util.*;

class Solution {
    public int[][] merge(int[][] arr) {

        // Sort according to starting value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int k = 0;

        for(int i = 1; i < arr.length; i++) {

            if(arr[k][1] >= arr[i][0]) {

                // merge
                arr[k][1] = Math.max(arr[k][1], arr[i][1]);

            } else {

                // next non-overlapping interval
                k++;
                arr[k][0] = arr[i][0];
                arr[k][1] = arr[i][1];
            }
        }

        // Create result with only valid intervals
        int[][] result = new int[k + 1][2];

        for(int i = 0; i <= k; i++) {
            result[i][0] = arr[i][0];
            result[i][1] = arr[i][1];
        }

        return result;
    }
}