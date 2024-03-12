#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
#include <list>
#include <unordered_map>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

const int M=1e9;
int n,A[2000];
int main() {
    fastio;
    // read_input;
    cin>>n;
    unordered_map<int,list<int>> map;
    for (int i=0;i<n;i++) {
        cin>>A[i];
        map[A[i]].push_back(i);
    }
    int ans=0;

    for (int i=0;i<n-1;i++) {
        for (int j=i+1;j<n;j++) {
            int cur=A[i]+A[j];
            if (map.find(cur)==map.end()) continue;
            for (auto it=map[cur].begin();it!=map[cur].end();) {
                if (*it==i || *it==j) ++it;
                else {
                    ans++;
                    map[cur].erase(it++);
                }
                
            }
        }
    }
    cout<<ans;
}
