#include <iostream>
#include <vector>
#include <deque>
#include <cstring>
#include <numeric>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 1'000'000
char str[MAX+1],bomb[37];

int main() {
    fastio;
    // read_input;
    cin>>str>>bomb;
    int n=strlen(str),m=strlen(bomb);
    vector<int> stk;
    bool flag=false;
    for (int i=0;i<n;i++) {
        if (str[i]==bomb[0]) stk.push_back(0);
        else if(!stk.empty()) {
            if (str[i]==bomb[stk.back()+1]) stk.push_back(stk.back()+1);
            else {
                flag=true;
                for (int i=0;i<(int)stk.size();i++) cout<<bomb[stk[i]];
                stk.clear();
                cout<<str[i];
            }
        } else cout<<str[i],flag=true;
        if (!stk.empty() && stk.back()==m-1) {
            for (int _=0;_<m;_++) stk.pop_back();
        }
    }
    if (!stk.empty()) {
        for(auto&i:stk)cout<<bomb[i];
        flag=true;
    }    
    if(!flag)cout<<"FRULA";
}
