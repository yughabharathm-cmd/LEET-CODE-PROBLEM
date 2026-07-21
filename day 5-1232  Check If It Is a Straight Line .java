#include <vector>

class Solution {
public:
    bool checkStraightLine(std::vector<std::vector<int>>& coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int i = 2; i < coordinates.size(); i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];

            // Cross-multiplication check to avoid division by zero
            if (dy * (xi - x0) != dx * (yi - y0)) {
                return false;
            }
        }

        return true;
    }
};
