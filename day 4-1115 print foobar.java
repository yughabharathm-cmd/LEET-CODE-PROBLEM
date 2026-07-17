#include <functional>
#include <mutex>
#include <condition_variable>

class FooBar {
private:
    int n;
    std::mutex mtx;
    std::condition_variable cv;
    bool foo_turn;

public:
    FooBar(int n) {
        this->n = n;
        this->foo_turn = true;
    }

    void foo(std::function<void()> printFoo) {
        for (int i = 0; i < n; i++) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this]() { return foo_turn; });
            printFoo();
            foo_turn = false;
            cv.notify_one();
        }
    }

    void bar(std::function<void()> printBar) {
        for (int i = 0; i < n; i++) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this]() { return !foo_turn; });
            printBar();
            foo_turn = true;
            cv.notify_one();
        }
    }
};
