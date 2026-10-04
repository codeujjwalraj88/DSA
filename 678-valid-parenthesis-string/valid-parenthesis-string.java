class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } 
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } 
            else { // '*'
                minOpen--;  // '*' can act as ')'
                maxOpen++;  // '*' can act as '('
            }

            // Even maximum possible '(' is negative
            if (maxOpen < 0) {
                return false;
            }

            // minOpen negative means we can treat '*' as empty
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        return minOpen == 0;
    }
}