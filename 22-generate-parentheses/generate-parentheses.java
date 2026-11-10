// class Solution {
//     static String generateparenthesis(int n){
//         String ans="";
//         for(int i=0;i<n;i++){
//             ans+="(";
//             ans+=")";
//         }
//         return ans;
//     }
//     static Set<String> allpermutations(String str,String ans,boolean[] visited,Set<String> set){
//         if(ans.length()==str.length()){
//             set.add(ans);
//             return set;
//         }
//         for(int i=0;i<str.length();i++){
//             if(visited[i]) continue;

//             visited[i]=true;
//             allpermutations(str,ans+str.charAt(i),visited,set);
//             visited[i]=false;
//         }
//         return set;
//     }
//     static boolean isvalid(String str){
//         if(str.length()==0){
//             return false;
//         }
//         Stack<Character> stack=new Stack<>();
//         for(int i=0;i<str.length();i++){
//             Character ch=str.charAt(i);
//             if(ch=='('||ch=='{'||ch=='['){
//                 stack.push(ch);
//                 continue;
//             }
//             if(stack.empty()) return false;
//             Character top=stack.peek();
//             if(ch=='}'&&top!='{') return false;
//             if(ch==']'&&top!='[') return false;
//             if(ch==')'&&top!='(') return false;
//             stack.pop();
//         }
//         return stack.empty();
//     }

//     public List<String> generateParenthesis(int n) {
//         Set<String> set=allpermutations(generateparenthesis(n),"",new boolean[2*n],new HashSet<>());
//         List<String> list=new ArrayList<>();
//         for(String str:set){
//             if(isvalid(str)){
//                 list.add(str);
//             }
//         }
//         return list;
//     }
// }
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