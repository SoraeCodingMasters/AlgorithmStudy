#include <iostream>
#include <algorithm>
using namespace std;

#define fastio cin.tie(0),cout.tie(0),ios::sync_with_stdio(false);
#define read_input freopen("input.txt","r",stdin);

int main() {
	fastio;
	//read_input;
	int n, a[100000], b[100000];
	cin >> n;
	for (int i = 0;i < n - 1;i++) cin >> a[i];
	for (int i = 0;i < n;i++)cin >> b[i];
	long long ans = 0;
	int cur = 1e9;
	for (int i = 0;i < n - 1;i++) {
		cur = min(cur, b[i]);
		ans += ((long long)cur * a[i]);
	}
	cout << ans;
}
