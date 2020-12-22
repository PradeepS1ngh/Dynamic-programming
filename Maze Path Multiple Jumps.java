
   //______________________________________________________________________________________________________
   //
   //*****************************  Maze Path ( H_V_D ) Multiple Jump ************************************//
   //______________________________________________________________________________________________________

   /*----------------RECURSIVE APPROACH-----------------*/
   public static int mazePath_HVD_Multi(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
      if(sr==er && sc==ec){
          return dp[sr][sc]=1;
      }
      if(dp[sr][sc]!=0) return dp[sr][sc];

      int count = 0;
      for(int d=0;d<dir.length;d++){
          for(int rad = 1;rad <= dp.length;rad++){
             int r = sr + rad*dir[d][0];
             int c = sc + rad*dir[d][1];

             if(r <= er && c <= ec)
              count += mazePath_HVD_Multi(r,c,er,ec,dp,dir);
             else break;
          } 
      }

      return dp[sr][sc] = count;
   }

   /*----------------DYNAMIC APPROACH-------------------*/
   public static int mazePath_HVD_Multi_DP(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
       for(sr = er;sr>=0;sr--){
           for(sc = ec;sc>=0;sc--){
               
               if(sr==er && sc==ec){
                   dp[sr][sc]=1;
                   continue;
               }

               int count = 0;
               for(int d=0;d<dir.length;d++){
                   for(int rad = 1;rad <= dp.length;rad++){
                      int r = sr + rad*dir[d][0];
                      int c = sc + rad*dir[d][1];
       
                      if(r <= er && c <= ec)
                       count += dp[r][c];
                      else break;
                   } 
               }
       
               dp[sr][sc] = count;
           }
       }

       return dp[0][0];
   }

  
