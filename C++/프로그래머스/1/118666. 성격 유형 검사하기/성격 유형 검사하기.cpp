#include <string>
#include <vector>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    int score[26] = {};   // 'A'~'Z', 반드시 0으로 초기화

    for (size_t i = 0; i < survey.size(); i++) {
        int c = choices[i];
        if (c < 4)      score[survey[i][0] - 'A'] += 4 - c;
        else if (c > 4) score[survey[i][1] - 'A'] += c - 4;
    }

    string answer;
    answer.reserve(4);
    for (const char* pair : {"RT", "CF", "JM", "AN"}) {
        char a = pair[0], b = pair[1];
        answer += (score[a - 'A'] >= score[b - 'A']) ? a : b;
    }
    return answer;
}