

    //______________________________________________________________________________________________________
    //
    //*****************************  Die Count Way using faces 1 to 6 ************************************//
    //______________________________________________________________________________________________________

    public static int boardPath(int n ){
        
        int dp[] = new int[n+1];
        //return boardPath_Recursive(0,n,dp);
        //return boardPath_DP(0,n,dp);
        //return boardPath_usingLL(0,n);
        return boardPath_Using6sizeArray(0,n);
        
    }

    /*----------------RECURSIVE APPROACH-----------------*/
    public static int boardPath_Recursive(int si,int ei,int dp[]){
        
        if(si == ei) return dp[si] = 1;
        
        if(si > ei) return 0;
        
        if(dp[si] != 0)  return dp[si];
        
        int count = 0;
        for(int die = 1;die <= 6;die++)
            count += boardPath_Recursive(si+die,ei,dp);
        dp[si] = count ;
        
        return count;
    }
    
    /*----------------DYNAMIC APPROACH-------------------*/
    public static int boardPath_DP(int si,int ei,int dp[]){
        
        for( si = ei ; si >= 0; si--){
            
            if(si == ei){  dp[si] = 1 ;    continue;   }
        
            int count = 0;
            for(int die = 1;die <= 6;die++)
                count += (si+die <= ei ) ? dp[si+die] : 0;    
            dp[si] = count ;
            
        }
        
        return dp[0];
    }
    
    /*----------------USINGH LinkedList-------------------*/
    public static int boardPath_usingLL(int si,int ei){
        
        LinkedList<Integer> ll = new LinkedList<>();
        
        for( si = ei ; si >= 0 ; si--){
            
            if(si >= ei - 1){
                ll.addFirst(1);
                continue;
            }
            
            if(ll.size() <= 6)
                ll.addFirst(2 * ll.getFirst());
            else
                ll.addFirst(2 * ll.getFirst() - ll.removeLast());   
        }
        return ll.getFirst();
    }
    
    /*----------------USING 6SIZE ARRAY-------------------*/
    public static int boardPath_Using6sizeArray(int si ,int ei){
        
        int arr[] = {1,1,2,4,8,16,32};
        
        if(ei <= 6)  return arr[ei];
        
        int idx = 6;
        for(si = 7 ; si <= ei ; si++){
            
            int val = arr[idx];
            idx = (idx+1)%7;
            val *= 2;
            
            val -= arr[idx];
            arr[idx] = val;
            
        }
        return arr[idx];
        
    }
    

    



