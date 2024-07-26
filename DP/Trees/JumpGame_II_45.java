package BLIND_75.DP.Trees;

public class JumpGame_II_45 {

    public static int jumpToDestination(int[] jumps,int cur,int step){

        //Negative base case
        if(cur >= jumps.length)
            return Integer.MAX_VALUE;

        //positive base case
        if(jumps[cur] == jumps[jumps.length-1] && cur == jumps.length-1)
            return step;

        int minstep = Integer.MAX_VALUE;
        for(int i = 1 ; i <= jumps[cur];i++){
            minstep = Math.min(minstep,jumpToDestination(jumps,cur+i,step+1));
        }

        return minstep;
    }

    public static int DP(int[] jumps){
        int[] dp = new int[jumps.length];
        int n = jumps.length;
        if(jumps[n-2] >= 1)
            dp[n-2] = 1;

        for(int i = n-3; i >= 0; i--){
           int min = Integer.MAX_VALUE;
           int s = i;
           for(int j = 0 ; j < jumps[i]; j++) {
               s++;
               if (dp[s] != 0 ) {
                   if (dp[s] < min)
                       min = dp[s];
               }
               else if(s == n-1)
                   min = 0;
               else continue;
               dp[i] = min+1;
           }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] jumps = new int[] {3,1,5,8};
        //System.out.println(jumpToDestination(jumps,0,0));
        System.out.println(DP(jumps));
    }

}
