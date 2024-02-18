#include <iostream>
#include <algorithm>
#include <list>
#include <set>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;
#define MAX 300

int P, M;

struct player {
	int level;
	string name;
	bool operator< (const player& other) const  {
		return name < other.name;
	}
};

int r_n = 0;
int rlev[MAX];
set<player> players[MAX];

bool can_enter(int& lev, int& id) {
	return !(lev<rlev[id] - 10 || lev>rlev[id] + 10);
}


int main() {
	fastio;
	//read_input;
	cin >> P >> M;

	int l;
	string name;
	list<int> cur_rooms;
	for (int i = 0;i < P;i++) {
		cin >> l >> name;
		bool entered = false;
		for (auto it = cur_rooms.begin();it != cur_rooms.end();it++) {
			if (can_enter(l, *it)) {
				entered = true;
				players[*it].insert({ l,name });
				if (players[*it].size() >= M) {
					cur_rooms.erase(it);
				}
				break;
			}
		}
		if (entered) continue;
		rlev[r_n] = l;
		players[r_n].insert({ l,name });
		if (M!=1) {
			cur_rooms.push_back(r_n);
		}
		r_n++;
	}
	for (int i = 0;i < r_n;i++) {
		if (players[i].size() >= M) cout << "Started!" << '\n';
		else cout << "Waiting!" << '\n';
		for (auto& p : players[i]) cout << p.level << ' ' << p.name << '\n';
	}
} 
