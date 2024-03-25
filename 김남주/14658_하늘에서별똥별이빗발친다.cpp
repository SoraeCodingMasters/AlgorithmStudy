#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(0)
#define read_input freopen("input.txt","r",stdin);
using namespace std;
struct E {int x,y;};
int n,m,l,k;
int dy[4]{1,1,-1,-1},dx[4]{-1,1,-1,1};
E pos[100];
int main() {
    fastio;
    cin>>n>>m>>l>>k;
    for (int i=0;i<k;i++) cin>>pos[i].x>>pos[i].y;
    int ans=0;
    for (int i=0;i<k;i++) {
        for (int j=0;j<k;j++) {
            int x1=pos[i].x,y1=pos[j].y;
            int x2=x1+l,y2=y1+l;
            int cur=0;
            for (int j=0;j<k;j++) if (pos[j].x>=x1 && pos[j].x<=x2 && pos[j].y>=y1 && pos[j].y<=y2) cur++;
            ans=max(ans,cur);
            }
    }
    cout<<k-ans;
}
