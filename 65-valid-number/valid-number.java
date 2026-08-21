class Solution {
    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // digit
            if (ch >= '0' && ch <= '9') {
                seenDigit = true;
            }

            // decimal point
            else if (ch == '.') {

                // dot cannot come after e
                // and only one dot is allowed
                if (seenDot || seenE) {
                    return false;
                }

                seenDot = true;
            }

            // exponent
            else if (ch == 'e' || ch == 'E') {

                // e only once
                // e must have a digit before it
                if (seenE || !seenDigit) {
                    return false;
                }

                seenE = true;

                // Now exponent must contain a digit
                seenDigit = false;
            }

            // + or -
            else if (ch == '+' || ch == '-') {

                // sign is valid only at beginning
                // OR immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            // anything else
            else {
                return false;
            }
        }

        return seenDigit;
    }
}