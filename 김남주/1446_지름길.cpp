#include <iostream>
#include <algorithm>
#include <set>
#include <queue>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

typedef tuple<int,int,int> tup;

#define MAX 10'000
int n,d;
int dp[MAX+1];
tup roads[12];

int main() {
    fastio;
    // read_input;

    cin>>n>>d;

    int s,e,c;
    for (int i=0;i<n;i++) {
        cin>>s>>e>>c;
        roads[i]={e,s,c};
    }
    sort(roads,roads+n);
    for (int i=0;i<=d;i++) dp[i]=i;
    for (auto& [e,s,c]:roads) {
        if(e>d) break;
        for (int i=0;i<n;i++) {
            int ce=get<0>(roads[i]);
            if (ce>s) break;
            dp[s]=min(dp[s],dp[ce]+s-ce);
        }
        dp[e]=min(dp[e],dp[s]+c);
        dp[d]=min(dp[d],dp[e]+d-e);
    }
    
    cout<<dp[d];
}
