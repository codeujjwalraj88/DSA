
import java.util.*;
class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i=prices.length-1;
        int j=discounts.length-1;
        List<Double>list=new ArrayList<>();
        while(i>=0&&j>=0){
         list.add(prices[i]*(100-discounts[j])/100.0);
         i--;
         j--;
        }
        
        if(i>=0){
            while(i>-1){
                list.add(Double.valueOf(prices[i]));
                i--;
            }
        }
        double ans=0;
        for(Double k:list){
             ans+=k;
        }
          return ans;
    }
}