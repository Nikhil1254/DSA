public class l003_1RecursionTrees {
    public static void main(String[] args) {
        coins();
    }

    // ============================================================================
    public static void coins() {
        int[] coins = {2,3,5,7} ;
        int tar = 10 ;
        
        // int count = coinPerInfi(tar,coins,"") ;
        // System.out.println("Total permutations : "+count) ;
        // int count = coinPerFinite(tar,coins,"");
        // System.out.println(count);
        // System.out.println("Coin Combination Infinite - ");
        // System.out.println(coinCombiInfi(tar,coins,0,""));
        // System.out.println("Coin combintion Finite - ");
        // System.out.println(coinCombiFinite(tar,coins,0,""));
        // System.out.println(coinPerInfi_sub(tar,coins,0,""));
        // System.out.println(coinPerFinite_sub(tar,coins,0,""));
    
        // System.out.println(coinCombiInfi_ss(tar,coins,0,""));
    
        System.out.println(coinCombiFinite_ss(tar,coins,0,""));
    }

    // =================================================================================================================================
    // Coin problems - 4 type of trees

    // coin permutation infinite
    public static int coinPerInfi(int tar,int[] coins,String ans){
        
        if(tar==0){
            System.out.println(ans);
            return 1 ;
        }
        
        int count = 0 ;
        
        for(int idx=0 ; idx<coins.length ; idx++){
            int coin = coins[idx] ;
            if(tar-coin>=0)
                count +=  coinPerInfi(tar-coin,coins,ans+coin+" ") ;
        }
        
        return count ;
    }
    
    //coin permutation finite
    public static int coinPerFinite(int tar,int[] coins,String ans){
        
        if(tar==0){
            System.out.println(ans);
            return 1 ;
        }
        
        int count = 0 ;
        
        for(int idx=0 ; idx<coins.length ; idx++){
            int coin = coins[idx] ;
            if(coin!=-1 && tar-coin>=0){
                coins[idx] = -1 ;
                count +=  coinPerFinite(tar-coin,coins,ans+coin+" ") ;
                coins[idx] = coin ;
            }
                
        }
        
        return count ;
    }
    
    // coin combination infinite - 
    public static int coinCombiInfi(int tar,int[] coins,int idx,String ans){
        if(tar==0){
            System.out.println(ans) ;
            return 1 ;
        }
        
        int count = 0 ;
        
        for(int i=idx ; i<coins.length ; i++){
            int coin = coins[i] ;
            if(tar-coin>=0)
                count += coinCombiInfi(tar-coin,coins,i,ans+coin+" ");
        }
        
        return count ;
    }
    
    // coin combination finite - 
    public static int coinCombiFinite(int tar,int[] coins,int idx,String ans){
        if(idx==coins.length || tar==0){
            if(tar==0){
                System.out.println(ans) ;
                return 1 ;
            }
            return 0 ;
        }
        
        int count = 0 ;
        
        for(int i=idx ; i<coins.length ; i++){
            int coin = coins[i] ;
            if(tar-coin>=0)
                count += coinCombiFinite(tar-coin,coins,i+1,ans+coin+" ");
        }
        
        return count ;
    }

    // ===================================================================================
    // coin problems using subsequence method - 4 trees

    // coin permutation infinite subsequence -
    public static int coinPerInfi_sub(int tar,int[] coins,int idx,String ans){
        if(idx==coins.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0 ;
        }
        
        int count = 0 ;
        if(tar-coins[idx]>=0)
            count += coinPerInfi_sub(tar-coins[idx],coins,0,ans+coins[idx]+" ");
            
        count += coinPerInfi_sub(tar,coins,idx+1,ans);
        
        return count ;
    }
    
    // coin permutation finite subsequence -
    public static int coinPerFinite_sub(int tar,int[] coins,int idx,String ans){
        if(idx==coins.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0 ;
        }
        
        int count = 0 ;
        
        if(coins[idx]!=-1 && tar-coins[idx]>=0){
            int coin = coins[idx] ;
            coins[idx] = -1 ;
            count += coinPerFinite_sub(tar-coin,coins,0,ans+coin+" ");
            coins[idx] = coin ;
        }
            
        count += coinPerFinite_sub(tar,coins,idx+1,ans);
        
        return count ;
    }
    
    // coin change Comibination Infi
    public static int coinCombiInfi_ss(int tar,int[] coins,int idx,String ans){
        if(idx==coins.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0 ;
        }
        
        int count = 0 ;
        
        if(tar-coins[idx]>=0)
            count += coinCombiInfi_ss(tar-coins[idx],coins,idx,ans+coins[idx]+" ");
            
        count += coinCombiInfi_ss(tar,coins,idx+1,ans);
        
        return count ;
    }
    
    // coin change Comibination Finite
    public static int coinCombiFinite_ss(int tar,int[] coins,int idx,String ans){
        if(idx==coins.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0 ;
        }
        
        int count = 0 ;
        
        if(tar-coins[idx]>=0)
            count += coinCombiFinite_ss(tar-coins[idx],coins,idx+1,ans+coins[idx]+" ");
            
        count += coinCombiFinite_ss(tar,coins,idx+1,ans);
        
        return count ;
    }

    
}
