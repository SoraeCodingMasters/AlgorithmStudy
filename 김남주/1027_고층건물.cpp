#include <iostream>
#include <queue>
#include <vector>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(0)
#define read_input freopen("input.txt","r",stdin);
using namespace std;
#define FOR(i, n) for (int i=0;i<(n);i++)

int n;
double h[50];
double grad[50][50];


inline int abs(int x) {return x<0?-x:x;}
bool chk(int s, int e) {
    grad[s][e]=(h[e]-h[s])/(e-s);
    for (int i=s+1;i<=e-1;i++) {
        if (grad[s][e]<=grad[s][i]) return false;
    }
    return true;
}
int num[50];

int main() {
    fastio;
    cin>>n;
    FOR(i, n) cin>>h[i];
    FOR(i, n) {
        for (int j=i+1;j<n;j++) {
            if (chk(i,j)) {
                ++num[i];
                ++num[j];
            }
        }
    }
    int ans=0;
    FOR(i, n) ans=max(ans,num[i]);
    cout<<ans;
}
