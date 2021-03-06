/**
 * -------------------Dynamic Programming Solution------------------------
 * class: StoneGame
 * In order for Alex to win, he has to get a greater score than Lee:
 * Alex's score > Lee Score
 * Because there are an odd number of stones, we know (if both players play optimally:
 * Alex's Score - Lee's Score > 0
 * The score is a parameter that both share:
 * score = Alex's score + Lee's score
 * Therefore, optimally Alex should try to increment that score as high as possible,
 * while Lee will try to lower the score, and the score will always be > 0.
 *
 * There are two choices to win the game:
 *
 * 1. If Alex chooses the first value(i), then Lee can only choose the next value (i+1)
 * or the last value(j), to choose a coin that makes the score as low as possible
 * value of i + min(F(i+2, j), F(i+1, j-1))
 *
 * 2. If Alex chooses the last value(j), then Lee can only choose the next value (j-1)
 * or the first value(i), to choose a coin that makes the score as low as possible
 * value of j + min(F(i+1, j-1), F(i, j-2) )
 *
 */
public class StoneGame {

    public static void main(String[] args) {
        int[] A = {8, 15, 3, 7};
        System.out.println("Alex wins the game: " + stoneGame(A));
    }

    public static boolean stoneGame(int[] a) {
        int n = a.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = a[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(a[i] - dp[i + 1][i + d], a[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }
}
