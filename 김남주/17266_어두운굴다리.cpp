#include <iostream>
#include <algorithm>
#include <queue>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 100'000

int n,m,pos[MAX+2];

bool check(const int& x) {
    pos[0]=-x;
    pos[m+1]=n+x;
    for (int i=1;i<=m;i++) {
        if (pos[i]-x>pos[i-1]+x) return false;
        if (pos[i]+x<pos[i+1]-x) return false;
    }
    return true;
}

int main() {
    fastio;
    // read_input;
    cin>>n>>m;
    for (int i=1;i<=m;i++) cin>>pos[i];
    int l=1,r=MAX;
    while (l<=r) {
        int mid=(l+r)/2;
        if (check(mid)) r=mid-1;
        else l=mid+1;
    }
    cout <<l;
}
