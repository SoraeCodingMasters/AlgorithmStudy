#include <iostream>
#include <vector>
#include <deque>
#include <cstring>
#include <numeric>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 1'000'000
string str,bomb;

int main() {
    fastio;
    // read_input;
    cin>>str>>bomb;
    int n=str.size(),m=bomb.size();
    int i=0,e=0;
    for (;e<n;e++) {
        str[i++]=str[e];
        if (i-m<0) continue;
        bool flag=false;
        for (int j=0;j<m;j++) {
            if (str[i-m+j]!=bomb[j]) {
                flag=true;
                break;
            }
        }
        if (flag) continue;
        i=i-m;
    }
    str.resize(i);
    cout<<str;
    if(!i) cout<<"FRULA";
}
