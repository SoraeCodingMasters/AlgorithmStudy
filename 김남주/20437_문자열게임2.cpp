#include <iostream>
#include <vector>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;


int T, K;
string W;
const int INF = 1e9;
vector<int> mem[26];

int main() {
	fastio;
	//read_input;

	cin >> T;
	while (T--) {
		cin >> W >> K;
		int ans1 = INF, ans2 = 0;
		int len = W.size();
		for (int i = 0;i < 26;i++) mem[i].clear();
		for (int i = 0;i < len;i++) mem[W[i] - 'a'].push_back(i);
		for (int i = 0;i < 26;i++) {
			for (int j = K - 1;j < (int)mem[i].size();j++) {
				ans1 = min(ans1, mem[i][j] - mem[i][j - K + 1] + 1);
				ans2 = max(ans2, mem[i][j] - mem[i][j - K + 1] + 1);
			}
		}
		if (ans1 == INF) { cout << -1 << '\n'; continue; }
		cout << ans1 << ' ' << ans2 << '\n';
	}
}
