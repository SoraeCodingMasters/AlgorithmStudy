#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 6

int dx[3]{ -1,0,1 };

int main() {
	fastio;
	//read_input;
	int n, m;
	cin >> n >> m;
	int g[MAX][MAX];
	for (int i = 0;i < n;i++) for (int j = 0;j < m;j++) cin >> g[i][j];
	int dp[MAX+1][MAX][3];
	int INF = 987654321;
	for (int j = 0;j < m;j++)dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = 0;
	for (int i = 1;i <= n;i++) {
		for (int j = 0;j < m;j++) {
			dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = INF;
			for (int d = 0;d < 3;d++) {
				if (j + dx[d] < 0 || j + dx[d] >= m) continue;
				for (int x = 0;x < 3;x++) {
					if (d == x)continue;
					dp[i][j][d] = min(dp[i][j][d], dp[i-1][j + dx[d]][x] + g[i - 1][j]);
				}
			}
		}
	}
	int ans = INF;
	for (int j = 0;j < m;j++) for (int k = 0;k < 3;k++) ans = min(ans, dp[n][j][k]);
	cout << ans;
}
