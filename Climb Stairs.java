
   //______________________________________________________________________________________________________
   //
   //***********************************  Climb Stairs  *************************************************//
   //______________________________________________________________________________________________________

   public  int climbStairs(int n) {
    int[] dp = new int[n + 1];
    // return climbStairs(n, dp);
    return climbStairs_DP(n,dp);
 }

 /*----------------RECURSIVE APPROACH-----------------*/
 public int climbStairs(int n,int[] dp) {
     if(n<=1){
         return dp[n] = 1;
     }

     if(dp[n]!=0) return dp[n]  ;
     
     int ans = climbStairs(n-1,dp) + climbStairs(n-2,dp);
     
     return dp[n] = ans;
 }

 /*----------------DYNAMIC APPROACH-------------------*/
 public int climbStairs_DP(int N,int[] dp) {
     for(int n = 0;n<=N;n++){
         if(n<=1){
             dp[n] = 1;
             continue;
         }
 
         int ans = dp[n-1] + dp[n-2];//climbStairs(n-1,dp) + climbStairs(n-2,dp);
         
         dp[n] = ans;
     }
     return dp[N];
 }

 

 
 
