#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n;

int dp2[10001];
int dp3[10001];

int main() {
	fastio;
	//read_input;
	int tc;
	cin >> tc;
	while (tc--) {
		cin >> n;
		memset(dp2, 0, sizeof(int) * (n + 1));
		memset(dp3, 0, sizeof(int) * (n + 1));
		
		dp2[2] = 1;
		dp2[3] = 1, dp3[3] = 1;
		for (int i = 4;i <= n;i++) {
			dp2[i] += (dp2[i - 2] + 1);
			dp3[i] += (dp2[i-3] + dp3[i - 3] + 1);
		}
		cout << 1 + dp2[n] + dp3[n] << '\n';
	}
}
