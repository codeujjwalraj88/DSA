class Solution {
    static boolean ispalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){return false;}
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                ans+=Character.toLowerCase(s.charAt(i));
            }
        }
        return  ispalindrome(ans);
    }
}