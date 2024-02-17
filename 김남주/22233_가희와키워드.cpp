#include <iostream>
#include <algorithm>
#include <string>
#include <sstream>
#include <unordered_set>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int n,m;

int main() {
    fastio;
    // read_input;
    cin>>n>>m;
    string tmp;
    unordered_set<string> kwords;
    for (int i=0;i<n;i++) {
        cin>>tmp;
        kwords.insert(tmp);
    }
    stringstream ss;
    for (int i=0;i<m;i++) {
        cin>>tmp;
        ss.str(tmp);
        while(getline(ss,tmp,',')) {
            auto it=kwords.find(tmp);
            if (it==kwords.end()) continue;
            kwords.erase(it);
            n--;
        }
        cout<<n<<'\n';
        ss.clear();
    }
}
