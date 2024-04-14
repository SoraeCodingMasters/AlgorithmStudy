#include <iostream>
#include <vector>
#include <stack>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(0)
#define read_input freopen("input.txt","r",stdin)

using namespace std;
#define MAX 100'000
struct E {
    int h, id;
};
int n, h[MAX], ans1[MAX], ans2[MAX];
E stk[MAX];
int sn=0;
int main() {
    fastio;
    // read_input;
    cin>>n;
    for (int i=0;i<n;i++) {
        cin>>h[i];
        while (sn && stk[sn-1].h<=h[i]) sn--;
        ans1[i]+=sn;
        if (ans1[i] && sn) ans2[i]=stk[sn-1].id;
        stk[sn++]={h[i],i+1};
    }
    sn=0;
    for (int i=n-1;i>=0;i--) {
        while (sn && stk[sn-1].h<=h[i]) sn--;
        ans1[i]+=sn;
        if (sn) {
            if (!ans2[i]) ans2[i]=stk[sn-1].id;
            else {
                if ((i+1) - ans2[i] > stk[sn-1].id - (i+1)) ans2[i]=stk[sn-1].id;
            }
        }
        stk[sn++]={h[i],i+1};
    }
    for (int i=0;i<n;i++) {
        cout<<ans1[i];
        if (ans1[i]) cout<<' '<<ans2[i];
        cout<<'\n';
    }
}
