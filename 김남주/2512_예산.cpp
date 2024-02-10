#include <iostream>

using namespace std;

#define fastio cin.tie(0),cout.tie(0),ios::sync_with_stdio(false)

int n,a[10000],b;

int x;
bool check() {
    if (x*n<=b) return true;
    int req=0;
    for (int i=0;i<n;i++) {
        req += (a[i]<=x?a[i]:x);
        if (req>b)return false;
    }
    return true;
}

int main() {
    fastio;
    cin>>n;
    int total=0;
    int max_a=0;
    for (int i=0;i<n;i++){
        cin>>a[i];
        max_a=max(max_a,a[i]);
        total+=a[i];
    }
    cin>>b;
    if (total<=b) {
        cout << max_a;
        return 0;
    }
    int l=0,r=100'000;
    while (l<=r) {
        x=(l+r)/2;
        if (!check())r=x-1;
        else l=x+1;
    }
    cout<<l-1;
}
