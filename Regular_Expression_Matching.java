//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
class Solution {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean dp[][] = new boolean[sl+1][pl+1];
        dp[0][0] = true;
        //top row
        for(int j = 1; j < dp[0].length; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //alphabet or '.'
                if(p.charAt(j-1) != '*'){
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
                else{
                    //if *
                    //zero
                    dp[i][j] = dp[i][j-2];
                    //one
                    //preceding char matches the char of s
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length-1];
    }
}
