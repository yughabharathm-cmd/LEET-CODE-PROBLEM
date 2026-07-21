class Solution {
public:
    bool isNumber(string s) {
        bool seenDigit = false;
        bool seenDot = false;
        bool seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            if (isdigit(c)) {
                seenDigit = true;
            } 
            else if (c == '+' || c == '-') {
                // A sign is only valid at the start or immediately after 'e'/'E'
                if (i > 0 && s[i - 1] != 'e' && s[i - 1] != 'E') {
                    return false;
                }
            } 
            else if (c == 'e' || c == 'E') {
                // 'e'/'E' can only appear once and must be preceded by a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure digits follow the exponent
            } 
            else if (c == '.') {
                // A dot can only appear once and cannot follow an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } 
            else {
                // Any other character is invalid
                return false;
            }
        }

        return seenDigit;
    }
};
