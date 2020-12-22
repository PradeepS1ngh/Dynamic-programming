
   //______________________________________________________________________________________________________
   //
   //*************************************  Maze Path ( H_V_D )  *****************************************//
   //______________________________________________________________________________________________________
   
   public static void mazePath(){
    int n = 3;
    int m = 3;

    int[][] dp = new int[n][m];
    int[][] dir = {{1,0},{0,1},{1,1}};

    // System.out.println(mazePath_HVD(0,0,n-1,m-1,dp,dir));
    // System.out.println(mazePath_HVD_Multi(0,0,n-1,m-1,dp,dir));

    // System.out.println(mazePath_HVD_DP(0,0,n-1,m-1,dp,dir));
    System.out.println(mazePath_HVD_Multi_DP(0,0,n-1,m-1,dp,dir));


    print2D(dp);
 }

 /*----------------RECURSIVE APPROACH-----------------*/
 public static int mazePath_HVD(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
     if(sr==er && sc==ec){
         return dp[sr][sc]=1;
     }
     if(dp[sr][sc]!=0) return dp[sr][sc];

     int count = 0;
     for(int d=0;d<dir.length;d++){
         int r = sr + dir[d][0];
         int c = sc + dir[d][1];

         if(r <= er && c <= ec)
           count += mazePath_HVD(r,c,er,ec,dp,dir); 
     }

     return dp[sr][sc] = count;
 }

 /*----------------DYNAMIC APPROACH-------------------*/
 public static int mazePath_HVD_DP(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
    for(sr = er;sr>=0;sr--){
        for(sc = ec;sc>=0;sc--){
            if(sr==er && sc==ec){
                dp[sr][sc]=1;
                continue;
            }

            
            int count = 0;
            for(int d=0;d<dir.length;d++){
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];
    
                if(r <= er && c <= ec)
                  count += dp[r][c]; 
            }
    
            dp[sr][sc] = count;
        }
    }

    return dp[0][0];
 }


 
 
