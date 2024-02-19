#include <iostream>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

typedef pair<int, int> pii;
#define MAX 1000
int n;
pii info[MAX + 1];
int nh[MAX];
int main() {
	fastio;
	//read_input;
	cin >> n;
	for (int i = 0;i < n;i++) {
		cin >> info[i].first >> info[i].second;
	}
	sort(info, info + n);
	info[n].first = info[n - 1].first + 1;
	int highest = 0;
	for (int i = n - 1;i >= 0;i--) {
		highest = max(highest, info[i+1].second);
		nh[i] = highest;
	}
	int ans = 0, ch = 0;
	for (int i = 0;i < n;i++) {
		if (ch < info[i].second) {
			ch = info[i].second;
		}
		ans += ch;
		if (ch > nh[i]) {
			ch = nh[i];
		}
		ans += ch * (info[i + 1].first - (info[i].first + 1));
	}
	cout << ans;
}
