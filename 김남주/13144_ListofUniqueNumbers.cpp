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

int main() {
    fastio;
    // read_input;
    cin>>n;
    int t;
    ll x=0;
    ll ans=0;
    int start=0;
    for (int i=1;i<=n;i++) {
        cin>>t;
        start=max(start,v[t]);
        v[t]=i;
        ans+=i-start;
    }
    cout<<ans;
}
