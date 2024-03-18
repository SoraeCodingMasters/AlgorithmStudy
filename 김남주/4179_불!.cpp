#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define FOR(i,n) for (int i=0;i<(n);i++)
using pii=pair<int,int>;
int dy[4]{0,0,1,-1},dx[4]{1,-1,0,0};
int r,c;
char g[1000][1000];
bool v[1000][1000];

int main() {
    fastio;
    // read_input;
    cin>>r>>c;
    queue<pii> fire;
    pii start;
    string tmp;
    FOR(i,r) { 
        cin>>tmp;
        FOR(j,c) {
            g[i][j]=tmp[j];
            if (g[i][j]=='J') start={i,j};
            else if(g[i][j]=='F') fire.push({i,j});
        }
    }
    int ans=0;
    queue<pii> q;
    q.push(start);
    v[start.first][start.second]=true;
    bool finish=false;
    while(!q.empty()) {
        int fsz=fire.size();
        while (fsz--) {
            auto[y,x]=fire.front();
            fire.pop();
            FOR(d,4) {
                int ny=y+dy[d],nx=x+dx[d];
                if (ny<0||ny>=r||nx<0||nx>=c||g[ny][nx]=='#'||g[ny][nx]=='F') continue;
                g[ny][nx]='F';
                fire.push({ny,nx});
            }
        }
        int qsz=q.size();
        while(qsz--) {
            auto[y,x]=q.front();
            q.pop();
            if (!y||!x||y==r-1||x==c-1) {
                finish=true;
                break;
            }
            FOR(d,4) {
                int ny=y+dy[d],nx=x+dx[d];
                if (ny<0||ny>=r||nx<0||nx>=c||g[ny][nx]=='#'||g[ny][nx]=='F'||v[ny][nx]) continue;
                v[ny][nx]=true;
                q.push({ny,nx});
            }
        }
        if (finish) break;
        ans++;
    }
    if (!finish) cout<<"IMPOSSIBLE";
    else cout<<ans+1;
}
