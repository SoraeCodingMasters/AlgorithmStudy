#include <iostream>
#include <deque>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)

using namespace std;

int n,k;
int hp[201];
int num[201];

int main() {
    fastio;
    deque<int> robot_pos;
    cin>>n>>k;
    
    for (int i=0;i<2*n;i++) {
        cin>>hp[i];
    }
    
    int ans=1;
    int up_pos=0,down_pos=n-1;
    while (true) {
        up_pos=up_pos?(up_pos-1):(2*n-1);
        down_pos=down_pos?(down_pos-1):(2*n-1);
        
        int idx=0;
        while (true) {
            if (idx>=(int)robot_pos.size()) break;
            auto& p=robot_pos[idx];
            if (p==down_pos) {
                num[p]--;
                robot_pos.pop_front();
                continue;
            }
            int next_pos=(p+1)%(2*n);
            if (num[next_pos]==0 && hp[next_pos]>0) {
                num[p]--;
                hp[next_pos]--;
                num[next_pos]++;
                p=next_pos;
            }
            if (p==down_pos) {
                num[p]--;
                robot_pos.pop_front();
                continue;
            }
            idx++;
        }
        if (hp[up_pos]>0) {
            robot_pos.push_back(up_pos);
            num[up_pos]++;
            hp[up_pos]--;
        }
        int cur_k=0;
        for (int i=0;i<2*n;i++) {
            if (!hp[i]) cur_k++;
        }
        if (cur_k>=k) break;
        ans++;
    }
    cout<<ans;
}
