#include <iostream>
#include <deque>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)

using namespace std;

int n,k;
int hp[201], pos[201];
bool num[201];

int main() {
    fastio;
    cin>>n>>k;
    
    for (int i=0;i<2*n;i++) {
        cin>>hp[i];
    }
    
    int ans=1;
    int up_pos=0,down_pos=n-1;
    int cur_k=0;
    int r_n=0;
    while (true) {
        up_pos=up_pos?(up_pos-1):(2*n-1);
        down_pos=down_pos?(down_pos-1):(2*n-1);
        
        int x=0;
        for (int i=0;i<r_n;i++) {
            auto& p=pos[i];
            if (p==down_pos) {
                num[p]=false;
                continue;
            }
            int next_pos=p==2*n-1?0:p+1;
            if (!num[next_pos] && hp[next_pos]>0) {
                num[p]=false;
                if(--hp[next_pos]==0) cur_k++;
                if (next_pos==down_pos) {
                    continue;
                }

                num[next_pos]=true;
                pos[x++]=next_pos;
            } else pos[x++]=p;
        }
        if (hp[up_pos]>0) {
            pos[x++]=up_pos;
            num[up_pos]=true;
            if(--hp[up_pos]==0)cur_k++;
        }
        if (cur_k>=k) break;
        ans++;
        r_n=x;
    }
    cout<<ans;
}
