#include <iostream>
#include <algorithm>
#include <vector>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 100'000

int n,m;
string name[MAX];
int val[MAX];

int main() {
    fastio;
    // read_input;

    cin>>n>>m;
    string cname;
    int cval;
    cin>>name[0]>>val[0];
    int num=1;
    for (int i=1;i<n;i++) {
        cin>>cname>>cval;
        if (cval==val[i-1]) continue;
        name[num]=cname;
        val[num]=cval;
        num++;
    }
    while (m--) {
        cin>>cval;
        int l=0,r=num-1;
        while (l<=r) {
            int mid=(l+r)/2;
            if (cval<=val[mid]) r=mid-1;
            else l=mid+1;
        }
        cout<<name[l]<<'\n';
    }
}
