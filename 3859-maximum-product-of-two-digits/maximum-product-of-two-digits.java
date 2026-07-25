class Solution {
    public int maxProduct(int n) {
        String str=String.valueOf(n);
        char[] ch=str.toCharArray();
        Arrays.sort(ch);
        return (ch[ch.length-1]-'0')*(ch[ch.length-2]-'0');
        
    }
}