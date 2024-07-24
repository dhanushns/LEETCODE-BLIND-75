package BLIND_75.DP;

public class ClimbingStairs_70 {

    //Recursion Method
    public static int waysToClimbTop(int n, int countWays,int steps){

        if(steps == n)
            return countWays+1;

        if(steps > n)
            return 0;

        return waysToClimbTop(n,countWays, steps +1) + waysToClimbTop(n, countWays, steps +2);
    }

    //DP Method Bottom-up

    public static int DP(int n){

        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;

        for(int i = 2; i <= n ; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }

        return steps[n];

    }

    public static void main(String[] args) {

        int n = 44;
        System.out.println("DP Method: " + DP(n));
        System.out.println("Recursive Method: " + waysToClimbTop(n,0,0));

    }

}
