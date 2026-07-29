class Solution {
    public int maxArea(int[] height) {
     //  int waterlevel=0;
     //  for(int i=0;i<height.length;i++){
     //   for(int j=i+1;j<height.length;j++){
     //       int ht=Math.min(height[i],height[j]);
     //       int wid=j-i;
     //       int curwaterlevel=ht*wid;
     //       waterlevel=Math.max(waterlevel,curwaterlevel);
     //   }
     //  } 
     //  return waterlevel;

     int first=0;
     int last=height.length-1;
     int max=-1;
     while(first<last){
        int length=Math.min(height[first],height[last]);
        int bredth=last-first;
        int level=length*bredth;
        max=Math.max(max,level);
        if(height[first]<height[last]){
            first++;
        }else{
            last--;
        }
     }
     return max;
    }
}