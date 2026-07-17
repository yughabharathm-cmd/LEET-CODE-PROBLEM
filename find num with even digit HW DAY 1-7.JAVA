class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for (int num : nums) {
            // Even digit counts correspond to ranges: 10-99 (2 digits) or 1000-9999 (4 digits) or 100000 (6 digits)
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000) {
                count++;
            }
        }
        return count;
    }
};
