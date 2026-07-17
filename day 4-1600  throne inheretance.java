#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class ThroneInheritance {
private:
    string king;
    unordered_map<string, vector<string>> family;
    unordered_set<string> dead;

    void dfs(const string& current, vector<string>& order) {
        if (dead.find(current) == dead.end()) {
            order.push_back(current);
        }
        if (family.find(current) != family.end()) {
            for (const string& child : family[current]) {
                dfs(child, order);
            }
        }
    }

public:
    ThroneInheritance(string kingName) {
        king = kingName;
    }
    
    void birth(string parentName, string childName) {
        family[parentName].push_back(childName);
    }
    
    void death(string name) {
        dead.insert(name);
    }
    
    vector<string> getInheritanceOrder() {
        vector<string> order;
        dfs(king, order);
        return order;
    }
};
