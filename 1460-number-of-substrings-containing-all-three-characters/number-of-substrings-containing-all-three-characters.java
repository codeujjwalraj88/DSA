class Solution {
    public int numberOfSubstrings(String s) {

        int[] freq = new int[3];
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                count += s.length() - right;

                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}





/*class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean a = false, b = false, c = false;

            for (int j = i; j < n; j++) {

                if (s.charAt(j) == 'a') a = true;
                if (s.charAt(j) == 'b') b = true;
                if (s.charAt(j) == 'c') c = true;

                if (a && b && c) {
                    count += n - j;
                    break;
                }
            }
        }

        return count;
    }
}*/