#include <iostream>
#include <algorithm>
#include <set>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

typedef pair<int,int> pii;
const int INF=1e9;

#define MAX 10'000
vector<pii> g[MAX+1];
int dist[MAX+1];
int n,d;

int main() {
    fastio;
    // read_input;
    cin>>n>>d;

    int a,b,c;
    set<int,greater<int>> nodeset;
    for (int i=0;i<n;i++) {
        cin>>a>>b>>c;
        g[a].push_back({c,b});
        nodeset.insert(a);
    }
    nodeset.insert(d);

    fill(&dist[0],&dist[MAX+1],INF);
    priority_queue<pii,vector<pii>,greater<pii>> pq;
    dist[0]=0;
    pq.push({0,0});
    while(!pq.empty()) {
        auto [cc,cp]=pq.top();
        pq.pop();
        if (cc>dist[cp]) continue;
        if (cp==d) {
            cout<<cc;
            return 0;
        }

        for (auto& next: nodeset) {
            if (next<cp) break;
            if (dist[next]<=cc+next-cp) continue;
            dist[next]=cc+next-cp;
            pq.push({dist[next],next});
        }

        for (auto& [nc,np]:g[cp]) {
            if (dist[np]<=cc+nc || np>d) continue;
            dist[np]=cc+nc;
            pq.push({dist[np],np});
        }
    }
}
