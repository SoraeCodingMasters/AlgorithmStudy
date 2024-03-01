#include <iostream>
#include <stack>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 500'000

int	n;

int main() {
	fastio;
	//read_input;
	cin >> n;
	int cur;
	stack<pair<int,int>> s;
	for (int i = 0;i < n;i++) {
		cin >> cur;
		while (!s.empty() && cur > s.top().first) s.pop();
		if (s.empty()) cout << '0';
		else cout << s.top().second;
		s.push({ cur,i + 1 });
		cout << ' ';
	}
}
