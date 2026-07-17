#include <functional>
#include <mutex>
#include <condition_variable>

class Foo {
private:
    std::mutex mtx;
    std::condition_variable cv;
    int turn;

public:
    Foo() {
        turn = 1;
    }

    void first(std::function<void()> printFirst) {
        std::unique_lock<std::mutex> lock(mtx);
        printFirst();
        turn = 2;
        cv.notify_all();
    }

    void second(std::function<void()> printSecond) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [this]() { return turn == 2; });
        printSecond();
        turn = 3;
        cv.notify_all();
    }

    void third(std::function<void()> printThird) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [this]() { return turn == 3; });
        printThird();
    }
};
