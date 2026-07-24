#include <vector>
#include <string>
#include <cctype>

using namespace std;

class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        // Map each lowercase letter 'a'-'z' to its keyboard row index (0, 1, or 2)
        // Row 0: q w e r t y u i o p
        // Row 1: a s d f g h j k l
        // Row 2: z x c v b n m
        const int charToRow[26] = {
            1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 
            2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2
        };

        vector<string> result;

        for (const string& word : words) {
            int row = charToRow[tolower(word[0]) - 'a'];
            bool isValid = true;

            for (char c : word) {
                if (charToRow[tolower(c) - 'a'] != row) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.push_back(word);
            }
        }

        return result;
    }
};
