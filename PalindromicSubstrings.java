/**
 * -------------------Dynamic Programming Solution------------------------
 * class: PalindromicSubstrings
 * I'm unsure about this solution, however, using dynamic programming, we can count recursively if the substring[i, j]
 * is a palindrome begins at the center, then I can find if substring[i-1..j+1] is palindrome. We can store this solution as a count, and check if the
 * left and right side of the word is a palindrome by treating it RECURSIVELY as the center palindrome as we are checking the center substring,
 * therefore, we are counting all posibilities recursively inside the first center substring.
 *
 */
public class PalindromicSubstrings {
}
