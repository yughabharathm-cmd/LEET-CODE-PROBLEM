#include <mutex>
#include <functional>

class DiningPhilosophers {
private:
    std::mutex forks[5];

public:
    DiningPhilosophers() {}

    void wantsToEat(int philosopher,
                    std::function<void()> pickLeftFork,
                    std::function<void()> pickRightFork,
                    std::function<void()> eat,
                    std::function<void()> putLeftFork,
                    std::function<void()> putRightFork) {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Lock both forks atomically to avoid deadlocks
        {
            std::scoped_lock lock(forks[leftFork], forks[rightFork]);

            pickLeftFork();
            pickRightFork();
            eat();
            putLeftFork();
            putRightFork();
        } // Locks are automatically released when leaving scope
    }
};
