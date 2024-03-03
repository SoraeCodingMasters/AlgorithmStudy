#include <iostream>
#include <queue>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
using namespace std;

int h,w,x[500],target[500];

int main() {
    fastio;
    cin>>h>>w;
    for (int i=0;i<w;i++) {
        cin>>x[i];
        target[i]=501;
    }
    target[0]=x[0],target[w-1]=x[w-1];
    queue<int> q;
    q.push(0),q.push(w-1);
    while (!q.empty()) {
        auto cur = q.front();
        q.pop();
        for (int i=-1;i<=1;i+=2) {
            if (cur+i<0 || cur+i>=w) continue;
            if (target[cur+i]<=target[cur]) continue;
            target[cur+i]=max(target[cur],x[cur+i]);
            q.push(cur+i);
        }
    }
    int ans=0;
    for (int i=0;i<w;i++) ans+=(target[i]-x[i]);
    cout<<ans;
}
