
class MyHashSet {
private:
    static const int SIZE = 769; // A prime number for better hash distribution
    vector<list<int>> table;

    int hash(int key) {
        return key % SIZE;
    }

public:
    MyHashSet() : table(SIZE) {}

    void add(int key) {
        int idx = hash(key);
        for (int k : table[idx]) {
            if (k == key) return;
        }
        table[idx].push_back(key);
    }

    void remove(int key) {
        int idx = hash(key);
        table[idx].remove(key);
    }

    bool contains(int key) {
        int idx = hash(key);
        for (int k : table[idx]) {
            if (k == key) return true;
        }
        return false;
    }
};
