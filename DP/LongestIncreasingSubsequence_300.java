package BLIND_75.DP;


public class LongestIncreasingSubsequence_300 {

    public static int subSeqLength(int n, int[] arr,int pos,int len){

        if(pos >= arr.length)
            return len;

        if(arr[pos] < n) {
            return len;
        }

        n = arr[pos];
        len = subSeqLength(arr[pos], arr, pos+1, len + 1);
        len = subSeqLength(n, arr, pos+1, len);

        return len;

    }

    public static void main(String[] args) {

        int[] arr = new int[] {0,1,0,3,2,3};
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++){
            int len = subSeqLength(arr[i],arr,i,0);
            System.out.println(len);
            if(len > max)
                max = len;
        }
        System.out.println(max);

    }

}
