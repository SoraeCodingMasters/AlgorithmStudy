#include <iostream>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;


int T, K;
string W;
const int INF = 1e9;
int mem[10000];

int main() {
	fastio;
	//read_input;

	cin >> T;
	while (T--) {
		cin >> W >> K;
		int ans1 = INF, ans2 = 0;
		int len = W.size();
		for (char c = 'a';c <= 'z';c++) {
			int num = 0;
			for (int i = 0;i < len;i++) {
				if (W[i] == c) {
					mem[num++] = i;
					if (num >= K) {
						ans1 = min(ans1, mem[num - 1] - mem[num - K] + 1);
						ans2 = max(ans2, mem[num - 1] - mem[num - K] + 1);
					}
				}
			}
		}
		if (ans1 == INF) { cout << -1 << '\n'; continue; }
		cout << ans1 << ' ' << ans2 << '\n';
	}
}
