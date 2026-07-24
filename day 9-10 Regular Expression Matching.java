#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        vector<vector<bool>> dp(m + 1, vector<bool>(n + 1, false));
        
        // Empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns with '*' matching an empty string (e.g., "a*", "a*b*")
        for (int j = 2; j <= n; j += 2) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                    // Match current character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    // Two cases for '*':
                    // 1. Treat '*' as matching 0 occurrences of the preceding element -> dp[i][j - 2]
                    // 2. Treat '*' as matching 1+ occurrences if preceding element matches s[i-1] -> dp[i - 1][j]
                    dp[i][j] = dp[i][j - 2];
                    
                    if (p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
};
