package BLIND_75.DP;

import java.util.Arrays;

public class LCS_1143 {

    //Time Limit Exceed problem
    public static int LCS(String s1,String s2,int n1,int n2){

        //Negative base case
        if(n1 < 0 || n2 < 0)
            return 0;

        //positive base case
        if(s1.charAt(n1) == s2.charAt(n2))
            return 1 + LCS(s1,s2,n1-1,n2-1);

        return Math.max(LCS(s1, s2, n1 - 1, n2), LCS(s1, s2, n1, n2 - 1));

    }

    //Memoization Approach
    public static int LCS(String s1,String s2,int n1,int n2,int[][] dp){

        //Negative base case
        if(n1 < 0 || n2 < 0)
            return 0;

        //Reduce Recursion
        if(dp[n1][n2] != -1)
            return dp[n1][n2];

        //positive base case
        if(s1.charAt(n1) == s2.charAt(n2)) {
            dp[n1][n2] = 1 + LCS(s1, s2, n1 - 1, n2 - 1,dp);
            return dp[n1][n2];
        }

        dp[n1][n2] = Math.max(LCS(s1, s2, n1 - 1, n2,dp), LCS(s1, s2, n1, n2 - 1,dp));
        return dp[n1][n2];

    }

    public static void main(String[] args) {

        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0 ; i < text1.length(); i++)
            Arrays.fill(dp[i],-1);

        //System.out.println(LCS(text1,text2,text1.length()-1,text2.length()-1));
        System.out.println(LCS(text1,text2,text1.length()-1,text2.length()-1,dp));

    }

}
