#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 200'000
#define MAP 100'000

int n, k;
int a[MAX],pre[MAX];
int map[MAP + 1];
int dp[MAP + 1];

int main() {
	fastio;
	//read_input;
	cin >> n >> k;
	for (int i = 0;i < n;i++) {
		cin >> a[i];
		pre[i] = map[a[i]];
		map[a[i]] = i;
	}
	
	int cur_s = 0;
	int ans = 0;
	for (int i = 0;i < n;i++) {
		if (++dp[a[i]] > k) {
			int next_s = i;
			for (int j = 0;j < k;j++) {
				next_s = pre[next_s];
			}
			next_s++;
			for (int j = cur_s;j < next_s;j++) dp[a[j]]--;
			cur_s = next_s;
		}
		ans = max(ans, i - cur_s + 1);
	}
	cout << ans;
}
