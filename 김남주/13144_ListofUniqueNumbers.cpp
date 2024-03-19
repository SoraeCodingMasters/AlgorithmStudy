#include <iostream>
#include <vector>
#include <deque>
#include <cstring>
#include <numeric>
#include <ctime>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

using ll = long long;
int n;
int val[100001];
bool v[100001];
int main() {
    fastio;
    // read_input;
    cin>>n;
    for (int i=0;i<n;i++)cin>>val[i];
    ll ans=0;
    int l=0,r=0;
    while(r<n) {
        if (v[val[r]]) {
            while(l<r && val[l]!=val[r]) v[val[l++]]=false;
            l++;
        } 
        v[val[r++]]=true;;
        ans+=r-l;
    }
    cout<<ans;
}
