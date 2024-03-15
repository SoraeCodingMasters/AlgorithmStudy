#include <iostream>
#include <vector>
#include <stack>
#include <cstring>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;
#define FOR(i,n) for (int i=0;i<(n);i++)

int dy[4]{ 1,-1,0,0 }, dx[4]{ 0,0,1,-1 };
int dp[20][20];
int r, c;
char g[20][20];

int ans = 0, cur = 0;
void dfs(int y, int x, int b) {
	if (dp[y][x] == b) return;
	dp[y][x] = b;
	ans = max(ans, ++cur);
	b |= (1 << (g[y][x] - 'A'));
	for (int d = 0;d < 4;d++) {
		int ny = y + dy[d], nx = x + dx[d];
		if (ny < 0 || ny >= r || nx < 0 || nx >= c || b & (1 << (g[ny][nx] - 'A'))) continue;
		dfs(ny, nx, b);
	}
	--cur;
}
int main() {
	fastio;
	//read_input;
	cin >> r >> c;
	FOR(i, r) FOR(j, c) { cin >> g[i][j]; dp[i][j] = -1; }
	dfs(0, 0, 0);
	cout << ans;
}
