package Algorithm.DynamicProgramming;

//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).
//Note:
//s could be empty and contains only lowercase letters a-z.
//p could be empty and contains only lowercase letters a-z, and characters like . or *.
//Example:
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

public class L0010RegularExpressionMatching {
    public static void main(String[] args){
        String s = "aabb";
        String p = "c*aab*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p){
        if((s == null && p != null) || (s != null && p == null))
            return false;
        if(s == null)
            return true;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= s.length(); i ++){
            dp[i][0] = false;
        }
        for(int i = 1; i <= p.length(); i++){
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j -1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }else
                    dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}
