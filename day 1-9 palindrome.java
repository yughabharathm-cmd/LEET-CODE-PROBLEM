class Solution {
public:
    bool isPalindrome(int x) {
        // Negative numbers are not palindromes.
        // Also, if the last digit is 0, the first digit must be 0 (only 0 itself satisfies this).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers, x should equal revertedNumber.
        // For odd-length numbers, we discard the middle digit with revertedNumber / 10.
        return x == revertedNumber || x == revertedNumber / 10;
    }
};
