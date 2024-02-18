#include <iostream>
#include <algorithm>
#include <vector>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

struct node {
	node* prev;
	node* next;
	char c;
};

node node_pool[600'000 + 5];
int node_num = 0;
node* get_new_node() {
	return &node_pool[node_num++];
}

node* insert(char c, node* target) {
	auto new_node = get_new_node();
	new_node->c = c;
	new_node->next = target->next, new_node->prev = target;
	target->next->prev = new_node;
	target->next = new_node;
	return new_node;
}

void del(node* target) {
	target->prev->next = target->next;
	target->next->prev = target->prev;
}

string str;
int main() {
	fastio;
	//read_input;
	cin >> str;
	node* head = get_new_node();
	node* tail = get_new_node();
	head->next = tail, head->prev = tail;
	tail->next = head, tail->prev = head;

	node* cur = head;
	for (auto& c : str) {
		cur=insert(c, cur);
	}
	int m;
	char cmd, c;
	cin >> m;
	cur = tail;
	for (int i = 0;i < m;i++) {
		cin >> cmd;
		switch (cmd)
		{
		case'L':
			if (cur->prev == head) break;
			cur = cur->prev;
			break;
		case'D':
			if (cur == tail) break;
			cur = cur->next;
			break;
		case'B':
			if (cur->prev == head) break;
			del(cur->prev);
			break;
		case'P':
			cin >> c;
			insert(c, cur->prev);
			break;
		}
	}
	cur = head->next;
	while (cur != tail) {
		cout << cur->c;
		cur = cur->next;
	}
}
