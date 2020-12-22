

   //______________________________________________________________________________________________________
   //
   //********************************  MIN Cost Climbing Stairs  *****************************************//
   //______________________________________________________________________________________________________

   public  int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[cost.length + 1];
    int ans = minCostClimbingStairs(cost,n,dp);
    // int ans = minCostClimbingStairs_DP(cost,n,dp);
    return ans;
 }

 /*----------------RECURSIVE APPROACH-----------------*/
 public int minCostClimbingStairs(int[] cost,int n,int[] dp){
     if(n<=1){
         return dp[n] = cost[n];
     }

     if(dp[n]!=0) return dp[n];

     int ans = Math.min(minCostClimbingStairs(cost,n-1,dp),minCostClimbingStairs(cost,n-2,dp));

     return dp[n] = ans + (n!=cost.length?cost[n]:0);
 }

 /*----------------DYNAMIC APPROACH-------------------*/
 public int minCostClimbingStairs_DP(int[] cost,int N, int[] dp){
     for(int n = 0 ;n<=N;n++){
         if(n<=1){
             dp[n] = cost[n];
             continue;
         }
 
         int ans = Math.min(dp[n-1],dp[n-2]);
 
         dp[n] = ans + (n != cost.length ? cost[n] : 0);
     }
     return dp[N];
 }

 

 