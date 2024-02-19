#include <iostream>
#include <algorithm>
#include <vector>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n;

int main() {
	fastio;
	//read_input;
	cin >> n;
	vector<int> ans(n);
	int cur;
	for (int i = 1;i <= n;i++) {
		cin >> cur;
		int cnt = 0;
		for (int j = 0;j < n;j++) {
			if (ans[j]) continue;
			if (cnt++ == cur) ans[j] = i;
		}
	}
	for (auto& i : ans)cout << i << ' ';
}
