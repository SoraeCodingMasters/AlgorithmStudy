#include <iostream>
#include <deque>

using namespace std;

#define fastio cin.tie(0),cout.tie(0),ios::sync_with_stdio(false)

int n,x;
int main() {
    fastio;
    cin>>n>>x;
    deque<int> dq(x);
    int ans=0,ans_num=1;
    for (auto&i:dq) {
        cin>>i;
        ans+=i;
    }
    int cur=ans;
    int tmp;
    for (int i=0;i<n-x;i++) {
        cin>>tmp;
        cur-=dq.front();
        dq.pop_front();
        dq.push_back(tmp);
        cur+=tmp;
        if (cur>ans) {
            ans=cur;
            ans_num=1;
        } else if (cur==ans) ans_num++;
    }
    if (!ans) cout<<"SAD";
    else cout << ans << '\n' << ans_num;
}
