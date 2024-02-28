#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

typedef pair<int, int> pii;

int dy[4]{ 0,0,1,-1 }, dx[4]{ 1,-1,0,0 };
int n, L, R;
int A[50][50];
bool v[50][50];

inline int abs(int x) { return x < 0 ? -x : x; }

inline bool is_open(int x) {
	return x >= L && x <= R;
}

queue<pii> q;
queue<pii> q2;
bool bfs(int sy, int sx) {
	q.push({ sy,sx });
	v[sy][sx] = true;
	int sum = 0, num = 0;
	while (!q.empty()) {
		auto [cy, cx] = q.front();
		q2.push({ cy,cx });
		sum += A[cy][cx];
		num++;
		q.pop();
		for (int d = 0;d < 4;d++) {
			int ny = cy + dy[d], nx = cx + dx[d];
			if (ny < 0 || ny >= n || nx < 0 || nx >= n || v[ny][nx] || !is_open(abs(A[cy][cx]-A[ny][nx]))) continue;
			v[ny][nx] = true;
			q.push({ ny,nx });
		}
	}
	while (!q2.empty()) {
		auto& [cy, cx] = q2.front();
		A[cy][cx] = sum / num;
		q2.pop();
	}
	return num > 1;
}


int main() {
	fastio;
	//read_input;
	cin >> n >> L >> R;
	
	for (int i = 0;i < n;i++) for (int j = 0;j < n;j++) cin >> A[i][j];
	int ans = 0;
	while (true) {
		memset(v, false, sizeof(v));
		bool finish = true;
		for (int i = 0;i < n;i++) {
			for (int j = 0;j < n;j++) {
				if (v[i][j]) continue;
				if (bfs(i, j)) finish = false;
			}
		}
		if (finish) break;
		ans++;
	}
	cout << ans;
}
