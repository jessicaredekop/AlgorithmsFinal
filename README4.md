/**
 * -------------------Dynamic Programming Solution------------------------
 * class: ArithmeticSlices
 * To solve this using dynamic programming, we iterate through the sequence, count the total number
 * of sub-columns that consists of at least three elements and the difference between the following two consecutive
 * elements is the same, then we add the number of equal-increasing sub-columns currently increased.
 * When the ith element meets
 *
 * dp[i+1]-A[i]==dp[i+1]-dp[i+2]
 *
 * we increment the add value and if the total
 * number of equal-order sub-columns is increased by the current value.
 * When the ith element A[i] does not conform to this rule, our count is set to 0, and we have our values at each index
 * dp[n].
 */

public class ArithmeticSlices {
}
