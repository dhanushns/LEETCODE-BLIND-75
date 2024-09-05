package BLIND_75.DP.Trees;

public class UncrossedLines_1035 {

    //Memoization Method
    public static int mm(int i,int j,int[] nums1,int[] nums2,int[][] dp){

        if(i == nums1.length || j == nums2.length)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        if(nums1[i] == nums2[j]) {
            dp[i][j] = 1 + mm(i+1,j+1,nums1,nums2,dp);
        }
        else {
            dp[i][j] = Math.max(mm(i,j+1,nums1,nums2,dp),mm(i+1,j,nums1,nums2,dp));
        }
        return dp[i][j];

    }

    //Tabulation Method
    public static int tm(int[] nums1,int[] nums2){

        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];

        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                if(nums1[i] == nums2[j])
                    dp[i+1][j+1] = 1 + dp[i][j];
                else dp[i+1][j+1] = Math.max(
                        dp[i][j+1],
                        dp[i+1][j]
                );
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4,1,4,4,3,5,5,1,4,4,4,1,4,3,4,2,4,2};
        int[] nums2 = {2,4,1,1,3,5,2,1,5,1,2,3,3,2,1,4,1,2,5,5};
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        System.out.println(mm(0,0,nums1,nums2,dp));
        System.out.println(tm(nums1,nums2));
    }

}
