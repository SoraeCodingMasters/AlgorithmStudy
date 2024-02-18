#include <iostream>
#include <algorithm>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define LMAX 600'000
#define RMAX 500'000

char lstack[LMAX], rstack[RMAX];
int lidx, ridx;

int main() {
	fastio;
	//read_input;
	cin >> lstack;
	int m;
	cin >> m;
	lidx = strlen(lstack) - 1;
	ridx = -1;

	char cmd, x;
	while (m--) {
		cin >> cmd;
		if (cmd == 'L') {
			if (lidx < 0) continue;
			rstack[++ridx] = lstack[lidx--];
		}
		else if (cmd == 'D') {
			if (ridx < 0) continue;
			lstack[++lidx] = rstack[ridx--];
		}
		else if (cmd == 'B') {
			if (lidx < 0) continue;
			lidx--;
		}
		else {
			cin >> x;
			lstack[++lidx] = x;
		}
	}
	for (int i = 0;i <= lidx;i++) cout << lstack[i];
	for (int i = ridx;i >=0;i--) cout << rstack[i];
}
