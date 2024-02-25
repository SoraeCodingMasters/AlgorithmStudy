#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n, d, k, c;
int dishes[30'000];
int eat[3000+1];

int main() {
	fastio;
	//read_input;

	cin >> n >> d >> k >> c;
	for (int i = 0;i < n;i++) cin >> dishes[i];
	
	int cnt = 0, ans = 0;
	for (int i = 0;i < k;i++) {
		if (eat[dishes[i]]++==0) cnt++;
	}
	if (!eat[c]) cnt++;
	ans = cnt;
	if (!eat[c]) cnt--;
	for (int i = k;i < n+k-1;i++) {
		if (--eat[dishes[(i - k) % n]] == 0) cnt--;
		if (eat[dishes[i % n]]++ == 0) cnt++;
		if (!eat[c]) cnt++;
		ans = max(ans, cnt);
		if (!eat[c]) cnt--;
	}
	cout << ans;
}
