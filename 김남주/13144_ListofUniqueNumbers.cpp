#include <iostream>
#include <vector>
#include <deque>
#include <cstring>
#include <numeric>
#include <ctime>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

using ll = long long;
int n;
int v[100001];
int val[100001];

int main() {
    fastio;
    // read_input;
    cin>>n;
    for (int i=1;i<=n;i++) cin>>val[i];
    int t;
    ll x=0;
    ll ans=0;
    int s=1;
    for (int i=1;i<=n;i++) {
        t=val[i];
        if(v[t]) {
            x=x-(v[t]+1-s);
            int tmp=v[t]+1;
            for (int j=s;j<=v[t];j++) v[val[j]]=0;
            s=tmp;
        }
        v[t]=i;
        ans+=++x;
    }
    cout<<ans;
}
