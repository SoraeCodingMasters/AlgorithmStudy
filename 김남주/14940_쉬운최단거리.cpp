#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

typedef pair<int, int> pii;
#define MAX 1000
int n, m;
int g[MAX][MAX];
int dy[4]{ 0,0,1,-1 }, dx[4]{ 1,-1,0,0 };
const int INF = 987654321;
int main() {
	fastio;
	//read_input;
	cin >> n >> m;
	int sy,sx;
	for (int i = 0;i < n;i++) for (int j = 0;j < m;j++) {
		cin >> g[i][j];
		if (g[i][j] == 2) sy = i, sx = j;
	}
	for (int i = 0;i < n;i++) for (int j = 0;j < m;j++) {
		if (g[i][j] == 1)g[i][j] = -1;
		else g[i][j] = 0;
	}
	g[sy][sx] = 1;
	queue<pair<int, int>> q;
	q.push({ sy,sx });
	while (!q.empty()) {
		auto [cy, cx] = q.front();
		q.pop();
		
		for (int d = 0;d < 4;d++) {
			int ny = cy + dy[d], nx = cx + dx[d];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m || g[ny][nx] >= 0) continue;
			g[ny][nx] = g[cy][cx] + 1;
			q.push({ ny,nx });
		}
	}
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < m;j++) {
			if (g[i][j] >= 1) cout << g[i][j] - 1;
			else cout << g[i][j];
			cout << ' ';
		}
		cout << '\n';
	}
}
