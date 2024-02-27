#include <iostream>
#include <cstring>

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
		char ans_c;
		int ans1 = INF;
		int ans2 = 0;
		int len = W.size();
		for (char c = 'a';c <= 'z';c++) {
			int s = 0, e = 0, num = 0;
			while (s <= e) {
				if (e < len && num < K) {
					if (W[e++] == c) {
						if (++num == K) {
							if (e - s < ans1) {
								ans1 = e - s;
							}
						}
					}
				}
				else if (e == len && num < K) break;
				else {
					if (W[s++] == c) --num;
					if (num == K) {
						if (e - s < ans1) {
							ans1 = e - s;
						}
					}
				}
			}
			num = 0;
			for (int i = 0;i < len;i++) {
				if (W[i] == c) {
					mem[num] = i;
					if (num - K + 1 >= 0) {
						ans2 = max(ans2, mem[num] - mem[num - K + 1] + 1);
					}
					num++;
				}
			}
		}
		if (ans1 == INF) { cout << -1 << '\n'; continue; }
		cout << ans1 << ' ' << ans2 << '\n';
	}
}
