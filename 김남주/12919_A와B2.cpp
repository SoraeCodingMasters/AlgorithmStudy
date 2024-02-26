#include <iostream>
#include <queue>
#include <deque>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;


string s, t;
bool possible = false;

void sol(int cur_A, int cur_B, deque<char>& dq, bool rev = false) {
	if (possible) return;
	if (!cur_A && !cur_B) {
		possible = true;
		if (rev) {
			for (int i = dq.size() - 1;i >= 0;i--) {
				if (dq[i] != s[(int)dq.size() - 1 - i]) {
					possible = false;
					break;
				}
			}
		}
		else {
			for (int i = 0;i < dq.size();i++) {
				if (dq[i] != s[i]) {
					possible = false;
					break;
				}
			}
		}
		return;
	}

	if (rev) {	
		if (dq.front() == 'A' && cur_A > 0) {
			dq.pop_front();
			sol(cur_A - 1, cur_B, dq, rev);
			dq.push_front('A');
		}
		if (dq.back() == 'B' && cur_B > 0) {
			dq.pop_back();
			sol(cur_A, cur_B - 1, dq, !rev);
			dq.push_back('B');
		}
	}
	else {
		if (dq.back() == 'A' && cur_A > 0) {
			dq.pop_back();
			sol(cur_A - 1, cur_B, dq, rev);
			dq.push_back('A');
		}
		if (dq.front() == 'B' && cur_B > 0) {
			dq.pop_front();
			sol(cur_A, cur_B - 1, dq, !rev);
			dq.push_front('B');
		}
	}
}

int main() {
	fastio;
	//read_input;

	cin >> s >> t;
	deque<char> dq;
	int s_a = 0, s_b = 0, t_a = 0, t_b = 0;
	for (auto& c : s) {
		if (c == 'A')s_a++;
		else s_b++;
	}
	for (auto& c : t) {
		if (c == 'A') t_a++;
		else t_b++;
		dq.push_back(c);
	}
	int target_A = t_a - s_a, target_B = t_b - s_b;
	if (target_A < 0 || target_B < 0) {
		cout << 0;
		return 0;
	}
	sol(target_A, target_B,dq);
	cout << possible;
}
