#include <iostream>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int main() {
	fastio;
	//read_input;
	string s;
	cin >> s;
	int len = 0;
	for (auto& c : s) {
		if (c == 'a') len++;
	}
	
	int ans = 1e9;
	int a_n = 0, b_n = 0;
	for (int i = 0;i < len;i++) {
		if (s[i] == 'a') a_n++;
		else b_n++;
	}
	ans = min(ans, b_n);
	if (!ans) { cout << 0; return 0; }
	int sn = s.size();
	for (int i = len;i < len+sn-1 ;i++) {
		if (s[(i - len)%sn] == 'a') a_n--;
		else b_n--;
		if (s[i % sn] == 'a') a_n++;
		else b_n++;
		ans = min(ans, b_n);
		if (!ans) { cout << 0; return 0; }
	}
	cout << ans;
}
