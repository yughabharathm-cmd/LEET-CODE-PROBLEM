#include <queue>

class MyStack {
private:
    std::queue<int> q;

public:
    MyStack() {
        // Constructor
    }
    
    // Pushes element x to the top of the stack.
    void push(int x) {
        int sz = q.size();
        q.push(x);
        
        // Rotate the queue to bring the newly added element to the front
        for (int i = 0; i < sz; i++) {
            q.push(q.front());
            q.pop();
        }
    }
    
    // Removes the element on the top of the stack and returns it.
    int pop() {
        int topElement = q.front();
        q.pop();
        return topElement;
    }
    
    // Returns the element on the top of the stack.
    int top() {
        return q.front();
    }
    
    // Returns true if the stack is empty, false otherwise.
    bool empty() {
        return q.empty();
    }
};

