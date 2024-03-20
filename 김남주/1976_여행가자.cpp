#include <iostream>
#include <queue>
#include <vector>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(0)
#define read_input freopen("input.txt","r",stdin);
using namespace std;

int n,m;
vector<int> g[200];
bool cluster[200];
bool v[200];

int main() {
    fastio;
    cin>>n>>m;
    int tmp;
    for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++) {
            cin>>tmp;
            if (tmp) g[i].push_back(j);
        }
    }
    for (int i=0;i<m;i++) {
        cin>>tmp;
        cluster[tmp-1]=true;
    }

    queue<int> q;
    q.push(tmp-1);
    v[tmp-1]=true;
    while(!q.empty()) {
        auto cur=q.front();
        q.pop();

        for (auto&next:g[cur]) {
            if (v[next])continue;
            v[next]=true;
            q.push(next);
        }
    }
    for (int i=0;i<n;i++) {
        if (cluster[i]) {
            if (!v[i]) {
                cout<<"NO";
                return 0;
            }
        }
    }
    cout<<"YES";
}
