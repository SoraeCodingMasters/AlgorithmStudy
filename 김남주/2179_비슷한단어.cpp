#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(0)
#define read_input freopen("input.txt","r",stdin);
using namespace std;

struct e {
    string s;
    int idx;
};
int n;
e a[20000];
int f(string& a, string& b) {
    int res=0;
    int sz=min(a.size(),b.size());
    for (int i=0;i<sz;i++) {
        if (a[i]!=b[i])return res;
        res++;
    }
    return res;
}
int main() {
    fastio;
    cin>>n;
    string tmp;
    for (int i=0;i<n;i++) {
        cin>>tmp;
        a[i]={tmp,i};
    }
    sort(a, a+n,[](const e& x, const e& y){
            return x.s<y.s;
            });
    int ans=0;
    int s,t=n+1;
    string sstr,tstr;
    for (int i=0;i<n;i++) {
        int pi=0;
        for (int j=i+1;j<n;j++) {
           int x=f(a[i].s,a[j].s);
           if (x<pi) break; 
           pi=x;
           if (x>ans) {
               ans=x;
               int ct=a[i].idx, cs=a[j].idx;
               string ctstr=a[i].s,csstr=a[j].s;
               if (cs>ct) swap(cs,ct),swap(ctstr,csstr);
               s=cs,t=ct,sstr=csstr,tstr=ctstr;
           } else if (x==ans) {
               int ct=a[i].idx, cs=a[j].idx;
               string ctstr=a[i].s,csstr=a[j].s;
               if (cs>ct) swap(cs,ct),swap(ctstr,csstr);
               if (cs<s ||(cs==s && ct<t)) {
                   s=cs,t=ct;
                   sstr=csstr,tstr=ctstr;
               }
           }
        }
    }
    cout<<sstr<<'\n'<<tstr;
}
