#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 1000
int n, m, v;
bool vis[MAX+1];
vector<int> g[MAX+1];

void dfs(int cur) {
	cout << cur << ' ';
	vis[cur] = true;
	for (auto& next : g[cur]) {
		if (vis[next]) continue;
		dfs(next);
	}
}

void bfs() {
	queue<int> q;
	q.push(v);
	vis[v] = true;
	while (!q.empty()) {
		auto cur = q.front();
		cout << cur << ' ';
		q.pop();
		for (auto& next : g[cur]) {
			if (vis[next]) continue;
			vis[next] = true;
			q.push(next);
		}
	}
}

int main() {
	fastio;
	//read_input;
	cin >> n >> m >> v;
	int a, b;
	int mn = 0;
	for (int i = 0;i < m;i++) {
		cin >> a >> b;
		g[a].push_back(b);
		g[b].push_back(a);
		mn = max({mn,a,b});
	}
	for (int i = 1;i <= mn;i++) sort(g[i].begin(), g[i].end());
	dfs(v);
	memset(vis, false, sizeof(vis));
	cout << '\n';
	bfs();
}
