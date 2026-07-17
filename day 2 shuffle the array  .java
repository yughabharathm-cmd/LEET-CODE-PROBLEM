class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> result(2 * n);
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];       // Places x_i at even indices (0, 2, 4...)
            result[2 * i + 1] = nums[i + n]; // Places y_i at odd indices (1, 3, 5...)
        }
        return result;
    }
};
