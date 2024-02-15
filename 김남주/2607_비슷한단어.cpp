#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int x[26];
int k[26];


int main() {
	fastio;
	//read_input;

	int n;
	cin >> n;
	string s;
	cin >> s;
	for (auto& c : s) x[c - 'A']++;
	int ans = 0;
	for (int i = 1;i < n;i++) {
		for (int j = 0;j < 26;j++) k[j] = 0;
		cin >> s;
		for (auto& c : s) k[c - 'A']++;
		int ldiff = 0, mdiff = 0;
		for (int j = 0;j < 26;j++) x[j] - k[j] < 0 ? ldiff += (-x[j] + k[j]) : mdiff += (x[j] - k[j]);
		if (ldiff + mdiff <= 1)ans++;
		else if (mdiff == 1 && ldiff == 1)ans++;
	}
	cout << ans;
}
