#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n,s,a[100'000];
int main() {
    fastio;
    // read_input;
    cin>>n>>s;
    for (int i=0;i<n;i++) cin>>a[i];
    int ans=1e9,cur=0;
    int l=-1,r=0;
    while (l<r) {
        if (r<n && cur<s) {
            cur+=a[r++];
        } else {
            cur-=a[++l];
        }
        if (cur>=s) ans=min(ans,r-l-1);
        else if (r==n) break;
    }
    cout<< (ans>100'000?0:ans);
