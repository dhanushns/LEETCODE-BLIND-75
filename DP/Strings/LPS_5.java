package BLIND_75.DP.Strings;

public class LPS_5 {

    public static boolean isPalindrome(String s){

        int i = 0 , j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }

    //Approach 1 : Recursion TLE
    public static String recursion(int start, int end, String sub, String s, String lps){

        if(isPalindrome(sub)){
            lps = sub;
            return lps;
        }

        if(start == s.length())
            return lps;

        if(end == s.length())
            return lps;

        String s1 = recursion(start,end-1,s.substring(start,end),s,lps);
        String s2 = recursion(start+1,s.length()-1,s.substring(start+1,s.length()),s,lps);

        return s1.length() > s2.length() ? s1 : s2;

    }

    //Approach 2 : Expand around center
    public static String expandAroundCenter(String s){

        int n  =s.length();
        int resLen = 0;
        String res = "";

        //Checks for each character
        for(int i = 0 ; i < n ; i++){

            //odd length palindrome string
            int left = i, right = i;
            res = EAC_helpler(left,right,s,res.length(),res,n);

            //even length palindrome string
            right = i+1;
            res = EAC_helpler(left,right,s,res.length(),res,n);

        }
        return res;
    }

    public static String EAC_helpler(int left,int right,String s,int resLen,String res,int n){
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            if((right - left) + 1 > resLen){
                resLen = right-left+1;
                res = s.substring(left,right+1);
            }
            left-=1;
            right+=1;
        }
        return res;
    }

    public static void longestPalindrome(String s){
        //System.out.println(recursion(0,s.length()-1,s,s,""));
        System.out.println(expandAroundCenter(s));
    }

    public static void main(String[] args) {
        String s = "xaabacxcabaaxcabaax";
        longestPalindrome(s);
    }

}
