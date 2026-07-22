class Solution {
   static int[][] rotate(int[][] mat){
         for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat[0].length;j++){
                //swap
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0;i<mat.length;i++){
            int left=0;
            int right=mat[0].length-1;
            while(left<right){
                int temp=mat[i][right];
                mat[i][right]=mat[i][left];
                mat[i][left]=temp;
                left++;
                right--;
            }
        }
        return mat;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        
      if(Arrays.deepEquals(mat,target))
          return true;
      for(int i=0;i<3;i++){
        rotate(mat);
         if(Arrays.deepEquals(mat,target))
             return true;
      }
      return false;
        
    }
}