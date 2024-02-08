#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

#define fastio cin.tie(0),cout.tie(0),ios::sync_with_stdio(false);
#define read_input freopen("input.txt","r",stdin);

#define MAX 100'000

int main() {
	fastio;
	//read_input;
	int n, m;
	cin >> n >> m;
	string tmp;
	vector<string> word(n);
	for (auto& i : word) cin >> i;
	sort(word.begin(), word.end(), [&](const string& a, const string& b) {
		if (a.size() > b.size()) return true;
		if (a.size() == b.size()) return a < b;
		return false;
	});
	vector<pair<int, int>> ans;
	for (int i = 0;i < n;i++) {
		if (word[i].size() < m) break;
		int num = 0;
		while (i < n-1 && word[i] == word[i + 1]) {
			num++;
			i++;
		}
		ans.push_back({ -num,i });
	}
	sort(ans.begin(), ans.end());
	for (auto& [_, idx] : ans) cout << word[idx] << '\n';
}
