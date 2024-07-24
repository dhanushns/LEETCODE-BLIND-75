package BLIND_75.DP;

import java.util.Arrays;

public class CoinChange_322 {

    //Recursive method straight forward High time complexity
    public static int countCoins(int[] coins,int pos,int sum,int target,int count){
        //positive base case
        if(sum == target)
            return count;

        //Negative base cases
        if(pos == coins.length)
            return Integer.MAX_VALUE;

        if(sum > target)
            return Integer.MAX_VALUE;

        return Math.min(countCoins(coins,pos,sum+coins[pos],target,count+1),countCoins(coins,pos+1,sum,target,count));
    }

    // DP Method Tabulation Approach
    public static int DP(int[] coins, int target){
        int[] dp = new int[target+1];
        Arrays.fill(dp,target+1);
        dp[0] = 0;

        for(int amount = 1; amount <= target;amount++){
            for(int coin : coins){
               if(coin <= amount){
                   dp[amount] = Math.min(dp[amount],dp[amount-coin] + 1);
               }
            }
        }

        return dp[target] > target ? -1 : dp[target];
    }

    public static void main(String[] args) {

        int[] coins = {1,2,5};
        //change(coins,0,11,0,new ArrayList<Integer>());
        System.out.println(countCoins(coins,0,0,4,0));
    }

}
