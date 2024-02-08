#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>
using namespace std;

#define fastio cin.tie(0),cout.tie(0),ios::sync_with_stdio(false);
#define read_input freopen("input.txt","r",stdin);

#define MAX 100'000
unordered_map<string, int> map;
string word[MAX];
int w_n = 0;

int main() {
	fastio;
	//read_input;
	int n, m;
	cin >> n >> m;
	string tmp;
	for (int i = 0;i < n; i++) {
		cin >> tmp;
		if (tmp.size() < m) continue;
		if (map[tmp]++ == 0) word[w_n++] = tmp;
	}
	int a_n, b_n;
	sort(word, word + w_n, [&](const string& a, const string& b) {
		a_n = map[a], b_n = map[b];
		if (a_n > b_n) return true;
		else if (a_n == b_n) {
			if (a.size() > b.size()) return true;
			if (a.size() == b.size()) return a < b;
		}
		return false;
	});
	for (int i = 0;i < w_n;i++) cout << word[i] << '\n';
}
