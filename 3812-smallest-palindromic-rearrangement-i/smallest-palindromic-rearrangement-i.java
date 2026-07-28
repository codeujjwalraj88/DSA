class Solution {

    static String smallestPalindrome(String s) {

        int friq[] = new int[26];
        StringBuilder left = new StringBuilder();
        String middle = "";

        for(char ch : s.toCharArray()){
            friq[ch-'a']++;
        }

        int odd = 0;

        for(int i=0;i<26;i++){

            if(friq[i] % 2 == 1){
                odd++;
                middle = String.valueOf((char)('a'+i));
            }

            for(int j=0;j<friq[i]/2;j++){
                left.append((char)('a'+i));
            }
        }

        if(odd > 1)
            return "";

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}





/*class Solution {
    static void allpermutation(String str,String ans,List<String>list){
        if(str.length()==0){
            list.add(ans);
            return ;

        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String nstr=str.substring(0,i)+str.substring(i+1);
            allpermutation(nstr,ans+ch,list);
        }
    }
    static boolean palindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String smallestPalindrome(String s) {
        List<String>list=new ArrayList<>();
        allpermutation(s,"",list);
        Collections.sort(list);
         for(String word:list){
            if(palindrome(word)){
                return word;
            }
         }
        return "";
    }
}*/