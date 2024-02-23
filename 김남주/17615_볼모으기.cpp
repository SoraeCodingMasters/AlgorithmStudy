#include <iostream>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n;
string s;
int main() {
    fastio;
    // read_input;
    cin>>n;
    cin>>s;
    int rn=0,bn=0;
    for (int i=0;i<n;i++) {
        if (s[i]=='R')rn++;
        else bn++;
    }
    if (rn==0 || bn==0) {
        cout<<0;
        return 0;
    }
    int lr=0,lb=0,rb=0,rr=0;
    for (int i=0;i<n;i++) {
        if (s[i]!='R') break;
        lr++;
    }
    for (int i=0;i<n;i++) {
        if(s[i]!='B') break;
        lb++;
    }
    for (int i=n-1;i>=0;i--) {
        if (s[i]!='R') break;
        rr++;
    }
    for (int i=n-1;i>=0;i--) {
        if (s[i]!='B') break;
        rb++;
    }
    cout<<min(rn-max(lr,rr),bn-max(lb,rb));
}
