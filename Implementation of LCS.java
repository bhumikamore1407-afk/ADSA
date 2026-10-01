public class LCS {

    // Function to calculate LCS length and DP table
    static int[][] LCS_LENGTH(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        // Create DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i][j - 1]);
                }
            }
        }

        return dp;
    }


    // Function to reconstruct the actual LCS
    static String BUILD_LCS(String X, String Y, int[][] dp) {

        int i = X.length();
        int j = Y.length();

        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {

                result.append(X.charAt(i - 1));

                i--;
                j--;

            } else if (dp[i - 1][j] >= dp[i][j - 1]) {

                i--;

            } else {

                j--;
            }
        }

        // Reverse because characters were added backwards
        return result.reverse().toString();
    }


    public static void main(String[] args) {

        String X = "BHUMIKA";
        String Y = "MORE";

        // Calculate DP table
        int[][] dp = LCS_LENGTH(X, Y);

        // Build actual LCS
        String lcs = BUILD_LCS(X, Y, dp);

        // Display result
        System.out.println("First String: " + X);
        System.out.println("Second String: " + Y);
        System.out.println("Length of LCS: " + dp[X.length()][Y.length()]);
        System.out.println("LCS: " + lcs);
    }
}
