#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

// 최종점수 -> 점수의 합 -> 각 문제의 점수: 최고점
// 풀이 제출 횟수
// 마지막 제출 시간

int T,n, k, t,m;
int record[100][103];
int result[100];

int main() {
	fastio;
	//read_input;

	cin >> T;
	int i, j, s;
	while (T--) {
		cin >> n >> k >> t >> m;
		for (int tmp = 0;tmp < n;tmp++) {
			for (int tmp2 = 0;tmp2 < k;tmp2++) record[tmp][tmp2] = 0;
			record[tmp][100] = record[tmp][101] = record[tmp][102] = 0;
			result[tmp] = tmp;
		}
		for (int q = 0;q < m;q++) {
			cin >> i >> j >> s;
			record[i - 1][101]++;
			record[i - 1][102] = q;
			if (record[i - 1][j - 1] < s) {
				record[i - 1][100] = record[i - 1][100] - record[i - 1][j - 1] + s;
				record[i - 1][j - 1] = s;
			}
		}
		sort(result, result + n, [](int& a, int& b) {
			if (record[a][100] > record[b][100]) return true;
			if (record[a][100] == record[b][100]) {
				if (record[a][101] < record[b][101]) return true;
				if (record[a][101] == record[b][101]) {
					return record[a][102] < record[b][102];
				}
			}
			return false;
		});
		int ans = 0;
		for (;ans < n;ans++)if (result[ans] == t - 1)break;
		cout << ans + 1<<'\n';
	}
}
