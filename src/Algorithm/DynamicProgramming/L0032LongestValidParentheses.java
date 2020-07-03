package Algorithm.DynamicProgramming;
//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//Example 1:
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
//Example 2:
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
public class L0032LongestValidParentheses {
    public static void main(String[] args){
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s){
        if(s == null || s.length() < 2)
            return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && dp[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
