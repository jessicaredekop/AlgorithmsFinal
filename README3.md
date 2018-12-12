/**
 * -------------------Dynamic Programming Solution------------------------
 * class: PerfectSquares
 * For dynamic programming, we only need to use the square roots up to the square root
 * of n numbers, because any number greater than sqrt(n) squared surpasses n.
 * We now create our base cases of the first few perfect squares.
 *
 * Now we have 2 cases:
 * 1. Starting from the last index, we could either use this particular number  n - squares[i]
 * 2. Starting from second before last, we find all the possibilities to the sum of n.
 *
 * Making dp[n][i] to be the minimum number of perfect squares required to get n.
 *
 * dp[n][i] = min(1 + dp[n - squares[i]][squares.length - 1], dp[n][i - 1])
 *
 */
public class PerfectSquares {

    public static void main(String[] args) {
        int n = 12;
        System.out.print("The minimum number of perfect squares for the number " + n);
        System.out.println(" is: " + minNumPerfectSquare(n));
    }

    public static int minNumPerfectSquare(int n){
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++){
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
                int temp = j*j;
                if (temp > i)
                    break;
                else dp[i] = Math.min(dp[i], dp[i-temp] + 1);
            }
        }

        return dp[n];
    }
}
