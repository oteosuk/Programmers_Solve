#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

struct PairHash {
    size_t operator()(const pair<long long, long long>& p) const {
        return hash<long long>()(p.first) ^ (hash<long long>()(p.second) << 1);
    }
};

int solution(vector<int> arrows) {
    const int dx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
    const int dy[8] = {1, 1, 0, -1, -1, -1, 0, 1};
    const long long OFF = 200001, W = 400003;   // 좌표 → 단일 정수 키

    auto key = [&](long long x, long long y) { return (x + OFF) * W + (y + OFF); };

    unordered_set<long long> visitedVertex;
    unordered_set<pair<long long, long long>, PairHash> visitedEdge;

    long long x = 0, y = 0;
    visitedVertex.insert(key(x, y));
    int answer = 0;

    for (int d : arrows) {
        for (int step = 0; step < 2; step++) {          // 반칸씩 두 번
            long long nx = x + dx[d], ny = y + dy[d];
            long long from = key(x, y), to = key(nx, ny);
            auto edge = from < to ? make_pair(from, to) : make_pair(to, from);

            if (visitedEdge.insert(edge).second) {       // 처음 지나는 간선
                if (!visitedVertex.insert(to).second)    // 도착점은 이미 방문
                    answer++;
            }
            x = nx; y = ny;
        }
    }
    return answer;
}