

   //______________________________________________________________________________________________________
   //
   //*************************************  Friends Pairing  *********************************************//
   //______________________________________________________________________________________________________


   /*----------------RECURSIVE APPROACH-----------------*/
   public static int friendsPairing(int n,int[] dp){
    if(n<=1){
        return dp[n] = 1;
    }

    if(dp[n]!=0) return dp[n];

    int single = friendsPairing(n-1,dp);
    int pairUp = friendsPairing(n-2,dp) * ( n - 1 );

    return dp[n] = single + pairUp;
}

/*----------------DYNAMIC APPROACH-------------------*/
public static int friendsPairing_DP(int N,int[] dp){
    for(int n = 0; n<=N;n++){
        if(n<=1){
           dp[n] = 1;
           continue;
        }

        int single = dp[n-1];//friendsPairing(n-1,dp);
        int pairUp = dp[n-2] * (n-1);//friendsPairing(n-2,dp) * ( n - 1 );

        dp[n] = single + pairUp;
    }
    return dp[N];
}

/*----------------OPTIMIZE APRROACH------------------*/
public static int friendsPairing_Opti(int N){
    int a = 1;
    int b = 1;
    for(int n = 2; n<=N;n++){
        int sum = b + a * (n-1); 
        a = b;
        b = sum; 
    }
    return b;
}





