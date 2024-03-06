#include <iostream>
#include <vector>
#include <stack>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n;
int main() {
    fastio;
    // read_input;
    cin>>n;
    stack<int> stk;
    int x,y;
    int ans=0;
    for (int i=0;i<n;i++) {
        cin>>x>>y;
        while (!stk.empty() && stk.top()>y) {
            stk.pop();
            ans++;
        }
        if (stk.empty() || stk.top()<y) stk.push(y);
    }
    while (!stk.empty() && stk.top()) {
        stk.pop();
        ans++;
    }
    cout<<ans;
}
