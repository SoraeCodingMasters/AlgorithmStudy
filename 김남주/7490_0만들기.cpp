#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int t,n;
// 1: -, 2: +, 3: ' '
char op[9] {'+',};
void sol(int idx) {
    if (idx==n) {
        int cur=0;
        char cop=op[0];
        for (int i=1;i<=n;) {
            int x=i;
            while (i<n && op[i]==' ') {
                x*=10;
                x+=(++i);
            }
            if (cop=='+') cur+=x;
            else cur-=x;
            cop=op[i++];
        }
        if (cur==0) {
            for (int i=1;i<n;i++) {
                cout<<i<<op[i];
            }
            cout<<n<<'\n';
        }
        return;
    }
    op[idx]=' ';
    sol(idx+1);
    op[idx]='+';
    sol(idx+1);
    op[idx]='-';
    sol(idx+1);
}
int main() {
    fastio;
    // read_input;
    cin>>t;
    while(t--) {
        cin>>n;
        sol(1);
        cout<<'\n';
    }
}
