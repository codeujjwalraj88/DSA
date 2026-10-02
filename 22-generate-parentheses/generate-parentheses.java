// 
class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        generate("", 0, 0, n, list);

        return list;
    }

    static void generate(String ans, int open, int close,
                         int n, List<String> list) {

        // complete string
        if (ans.length() == 2 * n) {
            list.add(ans);
            return;
        }

        // '(' add kar sakte hain
        if (open < n) {
            generate(ans + "(", open + 1, close, n, list);
        }

        // ')' tabhi add karenge jab opening bracket available ho
        if (close < open) {
            generate(ans + ")", open, close + 1, n, list);
        }
    }
}