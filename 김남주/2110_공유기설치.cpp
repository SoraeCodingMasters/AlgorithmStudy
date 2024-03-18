#include <iostream>
#include <vector>
#include <deque>
#include <cstring>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;
#define FOR(i,n) for (int i=0;i<(n);i++)

int n, c;
int pos[200'000];

bool chk(int x) {
	int cur = 1, prev = pos[0];
	for (int i = 1;i < n;i++) {
		if (pos[i] - prev < x) continue;
		if (++cur >= c) return true;
		prev = pos[i];
	}
	return false;
}
int main() {
	fastio;
	//read_input;
	cin >> n >> c;
	FOR(i, n)cin >> pos[i];
	sort(pos, pos + n);
	int l = 1, r = pos[n - 1] - pos[0];
	while (l <= r) {
		int x = (l + r) / 2;
		if (chk(x)) l = x + 1;
		else r = x - 1;
	}
	cout << r;
}
