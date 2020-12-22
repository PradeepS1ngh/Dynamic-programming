public class SequenceAndSubstring{

    //______________________________________________________________________________________________________
    //
    //*********************************  Largest Common SubSequence ***************************************//
    //______________________________________________________________________________________________________

    public static int LargestCommonSSeq(String str1,String str2){
        
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //return LargestCommonSSeq_Recursive(str1,str2,n,m);
        //return LargestCommonSSeq_Memoization(str1,str2,n,m,dp);
        return LargestCommonSSeq_DP(str1,str2,n,m,dp);

    }

    /*--------------- RECURSIVE APPROACH ----------------*/
    public static int LargestCommonSSeq_Recursive(String str1,String str2 ,int last_str1,int last_str2){
        
        if(last_str1 == 0 || last_str2 == 0)  return 0;
        
        if(str1.charAt(last_str1-1) == str2.charAt(last_str2-1))
            return 1 + LargestCommonSSeq_Recursive(str1,str2,last_str1-1,last_str2-1);
        else
            return Math.max(LargestCommonSSeq_Recursive(str1,str2,last_str1,last_str2-1),
                            LargestCommonSSeq_Recursive(str1,str2,last_str1-1,last_str2));
        
    }
    
    
    /*--------------- MEMOIZATION APPROACH ----------------*/
    public static int LargestCommonSSeq_Memoization(String str1,String str2 ,int last_str1,int last_str2,int dp[][]){
        
        if(last_str1 == 0 || last_str2 == 0)  return 0;
        
        if(dp[last_str1][last_str2] != 0)  return dp[last_str1][last_str2];
        
        if(str1.charAt(last_str1-1) == str2.charAt(last_str2-1))
            return dp[last_str1][last_str2] = 1 + LargestCommonSSeq_Memoization(str1,str2,last_str1-1,last_str2-1,dp);
        else
            return dp[last_str1][last_str2] = Math.max(LargestCommonSSeq_Memoization(str1,str2,last_str1,last_str2-1,dp),
                                                        LargestCommonSSeq_Memoization(str1,str2,last_str1-1,last_str2,dp));
        
    }
    

    /*---------------- DYNAMIC APPROACH -------------------*/
    public static int LargestCommonSSeq_DP(String str1,String str2 ,int last_str1,int last_str2,int dp[][]){

        for(last_str1 = 0; last_str1 < str1.length()+1 ;last_str1++){
            for(last_str2 = 0;last_str2 < str2.length()+1 ; last_str2++ ){
                
                if(last_str1 == 0 || last_str2 == 0)  continue;
                
                if(str1.charAt(last_str1-1) == str2.charAt(last_str2-1)) 
                    dp[last_str1][last_str2] = 1 + dp[last_str1-1][last_str2-1];
                else
                    dp[last_str1][last_str2] =
                            Math.max( dp[last_str1][last_str2-1] , dp[last_str1-1][last_str2] );
                
            }
        }
        return dp[str1.length()][str2.length()];
    }










    //______________________________________________________________________________________________________
    //
    //******************************  Printing Largest common subsequence ********************************//
    //______________________________________________________________________________________________________


    public static void PrintLCS(String s1,String s2){
        
        int n = s1.length();
        int m = s2.length();
        
        int dp[][] = new int[n+1][m+1];

        PrintLCS_DP(s1,s2,dp);
        
        int i = s1.length();
        int j = s2.length();
        String ansString = "";
        
        while(i != 0 && j != 0){
            
            System.out.println(i +  " " + j);
            
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ansString = s1.charAt(i-1) + ansString;
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1])   i--;
                else   j--;
            }     
        }
        
        System.out.println(ansString);
    }


    public static void PrintLCS_DP(String s1,String s2,int dp[][]){
        
        for(int i = 1;i <= s1.length();i++){
            for(int j = 1;j <= s2.length();j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);    
            }
        }
    }
    
    
    








    //________________________________________________________________________________________________________
    //
    //**************************  Longest Palindromic Subsequence ( length )  *******************************//
    //________________________________________________________________________________________________________

    public int longestPalindromeSubseq(String str) {
        
        int dp[][] = new int[str.length()][str.length()];
        return longestPalindromeSubseq_Recursive(str,0,str.length()-1,dp);
        
    }
    

    /*----------------RECURSIVE APPROACH-----------------*/
    public int longestPalindromeSubseq_Recursive(String s ,int i,int j,int dp[][]){
        
        if(i > j)  return 0;
        
        if(i == j) return 1;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = longestPalindromeSubseq_Recursive(s,i+1,j-1,dp) + 2 ;
            
        else return dp[i][j] = Math.max(longestPalindromeSubseq_Recursive(s,i+1,j,dp),
                            longestPalindromeSubseq_Recursive(s,i,j-1,dp));
        
    }


    /*----------------DYNAMIC APPROACH-------------------*/
    public static int longestPalindromeSubseq_DP(String str){
        
        int dp[][] = new int[str.length()][str.length()];
        for(int gap = 0 ; gap < str.length() ; gap++){
            for(int i = 0,j = gap; j < str.length() ;i++,j++){
                
                if(gap == 0){  dp[i][j] = 1;  continue;   }
                
                if(i > j) return 0;
        
                if(i == j) return dp[i][j] = 1;

                if(str.charAt(i) == str.charAt(j))  dp[i][j] = dp[i+1][j-1] + 2 ;
                else  dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);   

            }
        }
        return dp[0][str.length()-1];
    }












    //__________________________________________________________________________________________________
    //
    //*************************  Longest Palindromic Subsequence ( String )   ************************//
    //__________________________________________________________________________________________________


    public static void LPSSq(String str){
        
        int n = str.length();
        String dp[][] = new String[n][n];
        for(String d[] : dp){
            Arrays.fill(d,"");
        }
        
        for(int gap = 0 ;gap< n ;gap++){
            for(int i = 0,j = gap ;j<n;i++,j++){
                
                if(gap == 0){
                    dp[i][j] = "" + str.charAt(i);
                    continue;
                }                
                
                if(str.charAt(i) == str.charAt(j)){
                    char ch = str.charAt(i);
                    dp[i][j] = ch + dp[i+1][j-1] + ch ;
                }else{
                    dp[i][j] = (dp[i+1][j]).length() > (dp[i][j-1]).length() ? dp[i+1][j] : dp[i][j-1];
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }









    //__________________________________________________________________________________________________
    //
    //*******************************  Count All Palindromic Subsequence  ****************************//
    //__________________________________________________________________________________________________

    public static int CountAllPSSq(String str) {

        int n = str.length();
        //return CountAllPSSq_Recursive(str,0,n-1);
        return CountAllPSSq_DP(str);
    }
    

    /*----------------RECURSIVE APPROACH-----------------*/
    public static int CountAllPSSq_Recursive(String str , int i ,int j){
        
        if(i >= j)   return (i == j) ? 1 : 0 ;
        
        int A = CountAllPSSq_Recursive(str,i+1,j-1);
        int B = CountAllPSSq_Recursive(str,i+1,j);
        int C = CountAllPSSq_Recursive(str,i,j-1);
        
        if(str.charAt(i) == str.charAt(j))  return B + C + 1 ;
        else return B + C;
        
        
    }
    
    
    /*----------------DYNAMIC APPROACH-------------------*/
    public static int CountAllPSSq_DP(String str){
        
        int dp[][] = new int[str.length()][str.length()];
        for(int gap = 0;gap<str.length();gap++){
            for(int i = 0, j = gap ; j<str.length();i++,j++){
        
                if(i == j) {  dp[i][j] = 1  ;   continue  ;   }   
                
                int a = dp[i+1][j-1];
                int b = dp[i+1][j];
                int c = dp[i][j-1];
                
                if(str.charAt(i) == str.charAt(j))   dp[i][j] = b+c+1;
                else  dp[i][j] = b+c-a;
            }
        }
        return dp[0][str.length()-1];
    }














    //__________________________________________________________________________________________________
    //
    //*********************  Longest Palindromic SubString (Length, Count, String)  *******************//
    //___________________________________________________________________________________________________


    
    // we can calculate length,Count and String using same approach thats using boolean DP
    
    public static void LongestPalindromicSubString(String str){
        
        int lengthLPSSg = 0;
        int countLPSSg = 0;
        int Si = 0;
        int Sj = 0;
        
        int n = str.length();
        boolean dp[][] = new boolean[n][n];
        
        for(int gap = 0; gap < n ;gap++){
            for(int i = 0,j = gap ; j < n ;i++,j++){
                
                if(gap==0)  dp[i][j] = true;
                else if(gap == 1 && str.charAt(i) == str.charAt(j))   dp[i][j] = true;
                else     dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i+1][j-1];
            
                if(dp[i][j]){
                    countLPSSg++;
                    if(gap + 1 > lengthLPSSg){
                        lengthLPSSg = gap + 1;
                        Si = i;
                        Sj = j;
                    }
                }
            }
        } 

        System.out.println(" Length Of LPSSg is " + lengthLPSSg);
        System.out.println(" Count Of PSSg   is " + countLPSSg);
        System.out.println(" Longest  PSSg   is " + str.substring(Si,Sj+1));        

    }

    /*---------------  Count All LPSSG -------------------*/
    public int countSubstrings(String s) {

        int count = 0;
        
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        
        for(int gap = 0; gap < n;gap++){
            
            for(int i = 0 , j = gap ; j < n ;i++,j++){

                if(gap == 0) dp[i][j] = true;
                else if(gap == 1 && s.charAt(i) == s.charAt(j))  dp[i][j] = true;
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                
                if(dp[i][j])
                    count++;
            } 
        }
        return count; 
    }

    /*-----------------   LPSString   ------------------*/
    public String longestPalindrome(String s) {
        
        if(s.length() == 0) return "";
        int Si = 0;
        int Sj = 0;
        
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for(int gap = 0; gap < n ;gap++){
            for(int i = 0,j = gap ; j < n ; i++,j++){
                
                if(gap == 0)  dp[i][j] = true;
                else if(gap == 1 && s.charAt(i) == s.charAt(j))  dp[i][j] = true;
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                
                if(dp[i][j]){
                    Si = i;
                    Sj = j;
                }
                
            }
        }
        return s.substring(Si,Sj+1);
    }







    



    //__________________________________________________________________________________________________
    //
    //*************************************  Distinct Subsequences  **********************************//
    //___________________________________________________________________________________________________

    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        int dp[][] = new int[n+1][m+1];
        
        for(int d[] : dp)
            Arrays.fill(d,-1);
        
        return numDistinct_Recursive(s,t,n,m,dp);
        
    }
    

    /*----------------RECURSIVE APPROACH-----------------*/
    public static int numDistinct_Recursive(String s,String t,int n,int m,int[][] dp){
        
        if(n < m) return dp[n][m] = 0;
        
        if( m == 0 )  return dp[n+1][m+1] = 1;  
        
        if(dp[n][m] != -1) return dp[n][m];
        
        int count = 0;
        
        if(s.charAt(n-1) == t.charAt(m-1))  count += numDistinct_Recursive(s,t,n-1,m-1,dp);
        
        count += numDistinct_Recursive(s,t,n-1,m,dp);
        
        return dp[n][m] = count;
    }





}