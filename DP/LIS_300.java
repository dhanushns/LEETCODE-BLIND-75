package BLIND_75.DP;


import java.util.Arrays;

public class LIS_300 {

    public static int subSeqLength(int[] arr, int n){

        if(n == 0 || arr == null)
            return 0;

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = n-2; i >= 0 ; i--){
            for(int j = i+1; j < n ; j++){
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int ele : dp)
            max = Math.max(max,ele);
        return max;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {10, 22, 9, 33, 21, 50, 41, 60};
        int max = Integer.MIN_VALUE;
        System.out.println(subSeqLength(arr,arr.length));

    }

}
