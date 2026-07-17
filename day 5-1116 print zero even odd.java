#include <functional>
#include <mutex>
#include <condition_variable>

class ZeroEvenOdd {
private:
    int n;
    int state;
    int current;
    std::mutex mtx;
    std::condition_variable cv;

public:
    ZeroEvenOdd(int n) {
        this->n = n;
        this->state = 0;
        this->current = 1;
    }

    void zero(std::function<void(int)> printNumber) {
        for (int i = 0; i < n; i++) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this]() { return state == 0; });
            printNumber(0);
            if (current % 2 == 1) {
                state = 1;
            } else {
                state = 2;
            }
            cv.notify_all();
        }
    }

    void even(std::function<void(int)> printNumber) {
        for (int i = 2; i <= n; i += 2) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this]() { return state == 2; });
            printNumber(current);
            current++;
            state = 0;
            cv.notify_all();
        }
    }

    void odd(std::function<void(int)> printNumber) {
        for (int i = 1; i <= n; i += 2) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this]() { return state == 1; });
            printNumber(current);
            current++;
            state = 0;
            cv.notify_all();
        }
    }
};
