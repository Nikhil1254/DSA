public class l003RecursionTrees {
    public static void main(String[] args) {
        coins();
    }

    // ============================================================================
    public static void coins() {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        // System.out.println(permutationInfiCoins(coins, tar, ""));
        // System.out.println(combinationInfiCoins(coins, 0, tar, ""));
        // System.out.println(combinationSingleCoins(coins, tar, 0, ""));
        // System.out.println(permutationSingleCoins(coins, tar, " "));

        // using subsequnce method -
        // System.out.println(combinationSingleCoins_sub(coins, 0, tar, ""));
        // System.out.println(combinationInfiCoins_sub(coins, 0, tar, ""));
        // System.out.println(permutationInfiCoins_sub(coins, 0, tar, ""));
        // System.out.println(permutationSingleCoins_sub(coins, 0, tar, ""));
    }

    // =================================================================================================================================
    // Coin problems - 4 type of trees

    // 1. Coin permutation - infinite time coin can be used
    public static int permutationInfiCoins(int[] arr, int tar, String ans) {

        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int coin : arr)
            if (tar - coin >= 0)
                count += permutationInfiCoins(arr, tar - coin, ans + coin + "  ");

        return count;
    }

    // 2. Coin combination - infinite coins
    public static int combinationInfiCoins(int[] coins, int idx, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += combinationInfiCoins(coins, i, tar - coins[i], ans + coins[i] + " ");
        }

        return count;
    }

    // 3. Coin combination (use only once) -
    public static int combinationSingleCoins(int[] coins, int tar, int idx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += combinationSingleCoins(coins, tar - coins[i], i + 1, ans + coins[i] + " ");
        }

        return count;
    }

    // 4. Coin permutaton(Finite coins) -
    public static int permutationSingleCoins(int[] coins, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > 0 && tar - coins[i] >= 0) {
                int c = coins[i];
                coins[i] = -1;
                count += permutationSingleCoins(coins, tar - c, ans + c + " ");
                coins[i] = c;
            }

        }
        return count;
    }

    // ===================================================================================
    // coin problems using subsequence method - 4 trees

    // 1. combination finite coins -
    public static int combinationSingleCoins_sub(int[] coins, int idx, int tar, String ans) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += combinationSingleCoins_sub(coins, idx + 1, tar - coins[idx], ans + coins[idx] + " ");
        count += combinationSingleCoins_sub(coins, idx + 1, tar, ans);

        return count;
    }

    // 2. Combination infinite coins -
    public static int combinationInfiCoins_sub(int[] coins, int idx, int tar, String ans) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += combinationInfiCoins_sub(coins, idx, tar - coins[idx], ans + coins[idx] + " ");
        count += combinationInfiCoins_sub(coins, idx + 1, tar, ans);

        return count;
    }

    // 3. permutation Infi coins
    public static int permutationInfiCoins_sub(int[] coins, int idx, int tar, String ans) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (tar - coins[idx] >= 0)
            count += permutationInfiCoins_sub(coins, 0, tar - coins[idx], ans + coins[idx] + " ");
        count += permutationInfiCoins_sub(coins, idx + 1, tar, ans);

        return count;
    }

    // 4.Permutation finite coins
    public static int permutationSingleCoins_sub(int[] coins, int idx, int tar, String ans) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (coins[idx] > 0 && tar - coins[idx] >= 0) {
            int coin = coins[idx];
            coins[idx] = -1;
            count += permutationSingleCoins_sub(coins, 0, tar - coin, ans + coin + " ");
            coins[idx] = coin;
        }
        count += permutationSingleCoins_sub(coins, idx + 1, tar, ans);

        return count;
    }

    
}
