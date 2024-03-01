#include <iostream>
#include <stack>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
using namespace std;

int h,w,x[500];

int main() {
    fastio;
    cin>>h>>w;
    stack<pair<int,int>> stk;
    int cur,ans=0;
    int prev;
    int s,k;
    for (int i=0;i<w;i++) {
        cin>>cur;
        s=i;
        k=0;
        while(!stk.empty() && stk.top().first<=cur) {
            k=max(k,stk.top().first);
            s=stk.top().second;
            stk.pop();
        }
        if (!stk.empty()) {
            k=cur;
            s=stk.top().second+1;
        }
        for (int j=i-1;j>=s;j--) {
            ans+=k-x[j];
            x[j]=k;
        }
        x[i]=cur;
        stk.push({cur,i});
    }
    cout<<ans;
}
