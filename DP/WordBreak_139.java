package BLIND_75.DP;
import java.util.*;

public class WordBreak_139 {

    //Approach 1 Recursion Method
    public static boolean recursion(String word,List<String> dict){

        if(word.isEmpty())
            return true;

        for(int i = 1; i <= word.length(); i++){
            String substr = word.substring(0,i);
            if(dict.contains(substr) && recursion(word.substring(i),dict))
                return true;
        }

        return false;

    }

    public static boolean isContainsInDictionary(String word,List<String> dict){
        for(int i = 0 ; i < dict.size(); i++){
            if(dict.get(i).compareTo(word) == 0)
                return true;
        }

        return false;
    }

    // Approach 2 : DP --> Memoization --> Top down
    public static boolean memoization(int pos,String word,List<String> dict,HashSet<String> isSubstr){

        if(word.isEmpty())
            return true;

        if(isSubstr.contains(word))
            return true;

        String substr = "";
        for(int i = 0; i < word.length(); i++){
            substr += word.charAt(i);
            if(dict.contains(substr)) {
                isSubstr.add(substr);
                if(memoization(i+1,word.substring(i+1),dict,isSubstr))
                    return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> dict = new ArrayList<>(List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        //System.out.println(recursion(word,dict));
        System.out.println(memoization(0,word,dict,new HashSet<>()));
    }

}
