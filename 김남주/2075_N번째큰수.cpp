#include <iostream>
#include <algorithm>
#include <queue>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 1'500

int n, input[MAX][MAX];

struct comp {
	bool operator()(int& a, int& b) {
		return input[a / n][a % n] < input[b / n][b % n];
	}
};

int main() {
	fastio;
	//read_input;
	cin >> n;
	for (int i = 0;i < n;i++) for (int j = 0;j < n;j++) cin >> input[i][j];
	
	priority_queue<int, vector<int>,comp> pq;
	for (int i = 0;i < n;i++)pq.push((n - 1) * n + i);
	int x = 0;
	while (true) {
		auto cur = pq.top();
		pq.pop();
		if (++x == n) {
			cout << input[cur / n][cur % n];
			return 0;
		}
		if ((cur/n))pq.push(cur - n);
	}
}
