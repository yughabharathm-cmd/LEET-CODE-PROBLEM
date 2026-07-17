class ParkingSystem {
private:
    // Index 1 = Big, Index 2 = Medium, Index 3 = Small
    int count[4];

public:
    ParkingSystem(int big, int medium, int small) {
        count[1] = big;
        count[2] = medium;
        count[3] = small;
    }
    
    bool addCar(int carType) {
        if (count[carType] > 0) {
            count[carType]--;
            return true;
        }
        return false;
    }
};

