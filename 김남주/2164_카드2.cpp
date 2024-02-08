#include <iostream>
#include <cmath>
using namespace std;

#define fastio cin.tie(0),cout.tie(0),ios::sync_with_stdio(false);
#define read_input freopen("input.txt","r",stdin);

int main() {
	fastio;
	int n;
	cin >> n;
	bool f = false;
	int a=1;
	int x = 1;
	while (n > 1) {
		if (!f) {
			a += x;
			if (n%2) f = true;
			n /= 2;
		}
		else {
			if (n % 2) f = false, n = n / 2 + 1;
			else n /= 2;
		}
		x *= 2;
	}
	cout<<a;
}
