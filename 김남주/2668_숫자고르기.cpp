#include <iostream>
#include <vector>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n;
int a[101];
bool v[101];
bool v2[101];
int previ[101];
vector<int> ans;

void dfs(int cur) {
    if (v[cur]) return;
    if (v2[cur]) {
        ans.push_back(cur);
        v[cur]=true;
        int tmp=cur;
        cur=previ[cur];
        while(cur!=tmp) {
            ans.push_back(cur);
            v[cur]=true;
            cur=previ[cur];
        }
        return;
    }
    v2[cur]=true;
    previ[a[cur]]=cur;
    dfs(a[cur]);
    v2[cur]=false;
}

int main() {
    fastio;
    // read_input;
    cin>>n;
    for (int i=1;i<=n;i++) {
        cin>>a[i];
    }
    
    for (int i=1;i<=n;i++) {
        if (v[i]) continue;
        dfs(i);
    }
    sort(ans.begin(),ans.end());
    cout<<ans.size()<<'\n';
    for (auto& i: ans) cout<<i<<'\n';
}
