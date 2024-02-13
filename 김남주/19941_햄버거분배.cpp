#include <iostream>
#include <algorithm>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

bool map[26];
bool hamburger[20000];
bool not_avail[20000];
int n,k;

int ans=0;
void sol() {
    for (int i=0;i<n;i++) {
        if (hamburger[i]) continue;
        for (int j=i-k;j<=i+k;j++) {
            if (j<0||j>=n) continue;
            if (hamburger[j]&&!not_avail[j]) {
                ans++;
                not_avail[j]=true;
                break;
            }
        }
    }
}

int main() {
    fastio;
    // read_input;
    cin>>n>>k;
    map['H'-'A']=true,map['P'-'A']=false;
    char tmp;
    for (int i=0;i<n;i++) cin>>tmp,hamburger[i]=map[tmp-'A'];
    sol();
    cout << ans;
}
