#include <iostream>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 100'000
int n;
bool x[MAX],target[MAX];
const int INF=2e9;
int cur=0;  
int ans=INF;
void sol(int idx) {
    if (cur>ans)return;
    if (idx>=n) {
        ans=min(ans,cur);
        return;
    }
    if (!idx) {
        sol(1);

        x[0]=!x[0];
        x[1]=!x[1];
        cur++;
        sol(1);
        cur--;
        x[0]=!x[0];
        x[1]=!x[1];
    } else if (idx==n-1) {
        if (x[n-2]==target[n-2] && x[n-1]==target[n-1]) sol(idx+1);
        else if (x[n-2]!=target[n-2] && x[n-1]!=target[n-1]) {
            cur++;
            sol(idx+1);
            cur--;
        }
    } else {
        if (x[idx-1]==target[idx-1]) sol(idx+1);
        else {
            cur++;
            x[idx-1]=!x[idx-1];
            x[idx]=!x[idx];
            x[idx+1]=!x[idx+1];
            sol(idx+1);
            cur--;
            x[idx-1]=!x[idx-1];
            x[idx]=!x[idx];
            x[idx+1]=!x[idx+1];
        }
    }
}

int main() {
    fastio;
    // read_input;
    cin>>n;
    char c;
    for (int i=0;i<n;i++) 
        cin>>c,x[i]=c=='1';
    for (int i=0;i<n;i++) 
        cin>>c,target[i]=c=='1';
    sol(0);
    cout << (ans==INF?-1:ans);
}
