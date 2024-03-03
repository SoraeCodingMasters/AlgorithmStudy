#include <iostream>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n, a[100000];
inline int abs(int x) { return x < 0 ? -x : x; }
int main() {
	fastio;
	//read_input;
	cin >> n;
	for (int i = 0;i < n;i++) cin >> a[i];
	int ans = 2e9 + 1;
	int l = 0, r = n - 1;
	int a1, a2;
	while (l < r) {
		int x = a[l] + a[r];
		if (ans > abs(x)) {
			ans = abs(x);
			a1 = a[l], a2 = a[r];
		}
		if (x < 0) l++;
		else r--;
	}
	cout << a1 << ' ' << a2;
}
