/**
 * -------------------Dynamic Programming Solution------------------------
 * class: MinFallingPathSum
 * In order to find the smallest path we will have to create a second 2D array, moving
 * from the bottom up. The lower row will have all values, of the previous array, however
 * the rows leading up will have the values of the smallest sum between previous (RECURSION)
 * row below them. example if the index is [i][j], the value at that index will the the smallest
 * sum between itself and [i-1][j-1], [i-1[j], and [i-1][j+1].
 *
 * Then we return the smallest value at the top-most row in the array.
 *
 */
public class MinFallingPathSum {

    public static void main(String[] args){
        int[][] A = {{8, 15, 3, 7},
                {20, 15, 1, 40},
                {1, 4, 16, 18},
                {2, 12, 3, 0}};
        System.out.print("The minimum falling path sum is: ");
        System.out.println(minPathSum(A));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length-1; i <= 0; i--) {
            for (int j = grid.length-1; j <= 0; j--) {
                if (j == grid.length-1) dp[i][j] = grid[i][j];
                else if (j == 0) dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i-1][j + 1]);
                else if (j == grid.length-1) dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i-1][j - 1]);
                else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j+1], dp[i-1][j-1]));
            }
        }

        int minSum = dp[0][0];
        for(int i = 1; i < dp.length; i++){
            if(minSum > dp[i][0])
                minSum = dp[i][0];
        }
        return minSum;
    }
}
