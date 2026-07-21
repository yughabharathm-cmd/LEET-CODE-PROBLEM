#include <string>
#include <cctype>

class Solution {
public:
    bool detectCapitalUse(std::string word) {
        int capitalsCount = 0;

        for (char c : word) {
            if (std::isupper(c)) {
                capitalsCount++;
            }
        }

        // Case 1: All uppercase
        // Case 2: All lowercase
        // Case 3: Only the first character is uppercase
        return capitalsCount == word.length() || 
               capitalsCount == 0 || 
               (capitalsCount == 1 && std::isupper(word[0]));
    }
};
