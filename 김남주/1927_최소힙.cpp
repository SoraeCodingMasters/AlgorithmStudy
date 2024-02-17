#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 100'000
#define LEFT(i) (2*i)
#define RIGHT(i) (2*i+1)
#define PARENT(i) (i/2)
int n, heap[MAX + 1];
int heapsize = 0;

void insert(int x) {
	int i;
	heap[i=++heapsize] = x;
	while (i != 1) {
		if (heap[PARENT(i)] > heap[i]) {
			swap(heap[PARENT(i)], heap[i]);
			i = PARENT(i);
		}
		else break;
	}
}

void heapify(int i) {
	int t = i;
	if (LEFT(i) <= heapsize && heap[LEFT(i)] < heap[i]) t = LEFT(i);
	if (RIGHT(i) <= heapsize && heap[RIGHT(i)] < heap[t]) t = RIGHT(i);
	if (t != i) {
		swap(heap[i], heap[t]);
		heapify(t);
	}
}

void pop() {
	if (heapsize <= 0) return;
	heap[1] = heap[heapsize--];
	heapify(1);
}


int main() {
	fastio;
	//read_input;
	cin >> n;
	int x;
	while (n--) {
		cin >> x;
		if (x) insert(x);
		else {
			cout << heap[heapsize ? 1 : 0] << '\n';
			pop();
		}
	}
}
