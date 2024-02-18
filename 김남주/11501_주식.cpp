#include <iostream>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

typedef long long ll;
int a[1'000'000]{ 0, };

int main() {
	fastio;
	//read_input;
	int T;
	cin >> T;

	int n;
	while (T--) {
		cin >> n;
		ll ans = 0;
		int highest = 0;
		for (int i = 0;i < n;i++) cin >> a[i];
		for (int i = n - 1;i >= 0;i--) {
			highest = max(highest, a[i]);
			ans += (highest - a[i]);
		}
		cout << ans << '\n';
	}
}
