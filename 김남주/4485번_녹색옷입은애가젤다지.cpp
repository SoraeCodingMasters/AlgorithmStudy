#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

using pii=pair<int,int>;
constexpr int INF=1e9;
int n;
int g[125][125];
int dy[4]{0,0,1,-1},dx[4]{1,-1,0,0};

struct E {
    int dst,c;
    bool operator>(const E& o) const {return c>o.c;}
};
int dijkstra() {
    vector<vector<int>> dist(n,vector<int>(n,INF));
    dist[0][0]=g[0][0];
    priority_queue<E,vector<E>,greater<E>> pq;
    pq.push({0,g[0][0]});
    while (!pq.empty()) {
        int cy=pq.top().dst/n,cx=pq.top().dst%n;
        int cc=pq.top().c;
        pq.pop();
        if (cy==n-1 && cx==n-1) break;
        for (int d=0;d<4;d++) {
            int ny=cy+dy[d],nx=cx+dx[d];
            if (ny<0||ny>=n||nx<0||nx>=n) continue;
            if (dist[ny][nx]<=cc+g[ny][nx]) continue;
            dist[ny][nx]=cc+g[ny][nx];
            pq.push({ny*n+nx,dist[ny][nx]});
        }
    }
    return dist[n-1][n-1];
}

int main() {
    fastio;
    // read_input;
    cin>>n;
    int i=1;
    while(n) {
        for (int i=0;i<n;i++) for (int j=0;j<n;j++) cin>>g[i][j];
        cout<<"Problem "<<i<<": "<<dijkstra()<<'\n';
        cin>>n;
        ++i;
    }
}
