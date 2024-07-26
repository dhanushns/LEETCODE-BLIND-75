package BLIND_75.Strings;

public class subString {

    public static int isSubString(String s,String tar){

        int len = tar.length();

        int i = 0, j = len;
        while(j <= s.length()){
            String substr = s.substring(i,j);
            System.out.println(substr);
            if(substr.equals(tar))
                return i;
            i+=1;
            j+=1;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "abcabcabcd";
        String tar = "abcd";
        System.out.println(isSubString(s,tar));
    }
}
