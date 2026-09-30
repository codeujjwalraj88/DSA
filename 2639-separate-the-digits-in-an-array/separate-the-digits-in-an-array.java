class Solution {
    static int[] seperatenums(int[] nums) {

    String str = Arrays.toString(nums);
    StringBuilder sb = new StringBuilder(str);

    // [, ], comma, space remove
    for (int i = 0; i < sb.length(); i++) {

        if (sb.charAt(i) == '[' ||
            sb.charAt(i) == ',' ||
            sb.charAt(i) == ']' ||
            sb.charAt(i) == ' ') {

            sb.deleteCharAt(i);
            i--;
        }
    }

    // Direct StringBuilder → int[]
    int[] arr = new int[sb.length()];

    for (int i = 0; i < sb.length(); i++) {
        arr[i] = sb.charAt(i) - '0';
    }

    return arr;
}
    public int[] separateDigits(int[] nums) {
        int[] arr=seperatenums(nums);
        return arr;
    }
}