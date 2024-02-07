#include <iostream>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int t,n;
int a[1001],num[201],score[201],fif[201],cur_num[201];

int main() {
    fastio;
    // read_input;
    cin>>t;

    while (t--) {
        cin>>n;
        memset(num,0,sizeof(num));
        int t_n=0;
        for (int i=1;i<=n;i++) {
            cin>>a[i];
            t_n=max(t_n,a[i]);  
            num[a[i]]++;
        }
        for (int i=1;i<=t_n;i++) score[i]=0,fif[i]=0,cur_num[i]=0;
        int x=0;
        for (int i=1;i<=n;i++) {
            if (num[a[i]]<6) continue;
            ++x;
            if (++cur_num[a[i]]<=4) score[a[i]]+=x;
            if (cur_num[a[i]]==5) fif[a[i]]=x;
        }

        int min_score=1e9;
        for (int i=1;i<=t_n;i++) {
            if (num[i]<6) continue;
            if (min_score<score[i]) {
                min_score=score[i];
            }
            min_score=min(min_score,score[i]);
            
        }
        int ans=0;
        int min_fif=1e9;
        for (int i=1;i<=t_n;i++) {
            if (score[i]==min_score&&num[i]==6) {
                if (fif[i]<min_fif) {
                    min_fif=fif[i];
                    ans=i;
                }
            }
        }
        cout<<ans<<'\n';
    }
}
