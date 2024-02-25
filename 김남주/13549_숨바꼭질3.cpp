#include <iostream>
#include <queue>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 100'000

int n, k;
int v[MAX + 3];

int main() {
	fastio;
	//read_input;

	cin >> n >> k;
	if (n >= k) { cout << n - k; return 0; }
	queue<int> q;
	q.push(n);
	v[n] = true;
	int ans = 0;
	while (!q.empty()) {
		int qsz = q.size();
		while (qsz--) {
			auto cur = q.front();
			q.pop();
			if (cur == k) {
				cout << ans;
				return 0;
			}
			if (!v[cur + 1]) {
				v[cur + 1] = true;
				q.push(cur + 1);
			}
			if (!cur) continue;
			if (!v[cur - 1]) {
				v[cur - 1] = true;
				q.push(cur - 1);
			}
			for (int i = cur * 2;i <= k+1;i *= 2) {
				v[i] = true;
				if (i == k) { cout << ans; return 0; }
				if (!v[i - 1]) {
					v[i - 1] = true;
					q.push(i - 1);
				}
				if (!v[i + 1]) {
					v[i + 1] = true;
					q.push(i + 1);
				}
			}
		}
		ans++;
	}
}
