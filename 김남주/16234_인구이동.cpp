#include <iostream>
#include <vector>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n, L, R;
int A[2500],p[2500],num[2500];

int root(int x) {
	return p[x] < 0 ? x : p[x]=root(p[x]);
}

void union_p(int a, int b) {
	a = root(a), b = root(b);
	if (a == b) return;
	if (a > b) swap(a, b);
	p[a] += p[b], p[b] = a;
	num[a] += num[b], num[b] = 0;
}

inline int abs(int x) {
	return x < 0 ? -x : x;
}
inline bool is_open(int x) {
	return x >= L && x <= R;
}

int main() {
	fastio;
	//read_input;
	cin >> n >> L >> R;
	for (int i = 0;i < n * n;i++) {
		cin >> A[i];
		p[i] = -A[i]-1;
		num[i] = 1;
	}

	int ans = 0;
	while (true) {
		bool finish = true;
		for (int i = 0;i < n;i++) {
			for (int j = 0;j < n;j++) {
				if (i < n - 1) {
					if (is_open(abs(A[i * n + j] - A[(i + 1) * n + j]))) {
						finish = false;
						union_p(i * n + j, (i + 1) * n + j);
					}
				}
				if (j < n - 1) {
					if (is_open(abs(A[i * n + j] - A[i * n + j + 1]))) {
						finish = false;
						union_p(i * n + j, i * n + j + 1);
					}
				}
			}
		}

		if (finish) break;
		ans++;
		for (int i = 0;i < n * n;i++) {
			int r = root(i);
			A[i] = (-p[r]-num[r]) / num[r];
		}
		for (int i = 0;i < n * n;i++) {
			p[i] = -A[i]-1;
			num[i] = 1;
		}
	}
	cout << ans;
}
