package Algorithm.DynamicProgramming;

//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//Example 1:
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//Input: "cbbd"
//Output: "bb"

public class L0005_LongestPalindromicSubstring {
    public static void main(String[] args){
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s){
        if(s == null || s.length() == 0)
            return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                    if(i - j > end - start){
                        end = i;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
