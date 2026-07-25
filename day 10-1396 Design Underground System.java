class UndergroundSystem {
private:
    unordered_map<int, pair<string, int>> checkIns;
    unordered_map<string, pair<double, int>> routeData;

public:
    UndergroundSystem() {}

    void checkIn(int id, string stationName, int t) {
        checkIns[id] = {stationName, t};
    }

    void checkOut(int id, string stationName, int t) {
        auto [startStation, startTime] = checkIns[id];
        checkIns.erase(id);

        string routeKey = startStation + "->" + stationName;
        int duration = t - startTime;

        routeData[routeKey].first += duration;
        routeData[routeKey].second += 1;
    }

    double getAverageTime(string startStation, string endStation) {
        string routeKey = startStation + "->" + endStation;
        auto [totalTime, count] = routeData[routeKey];
        return totalTime / count;
    }
};
