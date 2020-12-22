
   //______________________________________________________________________________________________________
   //
   //********************************    Fibonacci Series    **********************************************//
   //______________________________________________________________________________________________________
   
   public static void fibo(){
    int n = 10;
    int[] dp=new int[n+1];
    System.out.println(fibo(n,dp));
    System.out.println(fibo_DP(n,dp));
    System.out.println(fibo_Opti(n));

    print(dp);
 }



 
 /*----------------RECURSIVE APPROACH-----------------*/
 public static int fibo(int n,int[] dp){
     if(n<=1){
         return dp[n] = n;   //store
     }
     if(dp[n]!=0) return dp[n]; // use of previous answer

     int ans = fibo(n-1,dp) + fibo(n-2,dp);
     return dp[n] = ans;   // store 
 }




 /*----------------DYNAMIC APPROACH-------------------*/
 public static int fibo_DP(int N,int[] dp){
     for(int n = 1;n<=N;n++){
         if(n<=1){
             dp[n] = n; 
             continue;
         }

         int ans = dp[n-1] + dp[n-2]; //fibo(n-1,dp) + fibo(n-2,dp);
         dp[n] = ans;                
     }

     return dp[N];
 }



 /*----------------OPTIMIZE APRROACH------------------*/
 public static int fibo_Opti(int N){
     int a = 0;
     int b = 1;

     for(int i=2;i<=N;i++){
         int sum = a + b;
         a = b;
         b = sum;
     }
     return b;
 }




 /*----------------MATRIX APPRAOCH--------------------*/
 public int fib_Matrix(int N) {
    
    if(N == 0 || N == 1) return N;

    int temp[][] = {{1,1},{1,0}};
    int ans[][] = Powerfunction(temp,N);
    return ans[0][1]; 
    
 }
 public static int[][] Powerfunction(int temp[][],int N){
    
    if(N == 1)  return temp;
    
    if(N%2 == 1){
        N--;
        int recAns[][] = Powerfunction(MatrixMultiply(temp,temp),N/2);
        return MatrixMultiply(temp,recAns);
    }

    return Powerfunction(MatrixMultiply(temp,temp),N/2);        
 }
 public static int[][] MatrixMultiply(int m1[][],int m2[][]){
        
    int ans[][] = new int[2][2];

    ans[0][0] = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];
    ans[0][1] = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];
    ans[1][0] = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];
    ans[1][1] = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1];
        
    return ans;  
 }

 
 

 
