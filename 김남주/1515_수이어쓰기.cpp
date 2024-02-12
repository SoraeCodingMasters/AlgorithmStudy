#include <iostream>
#include <algorithm>
#include <string>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;


int cur=0;
int cur_c;
bool include[10];
string input;
void set_include() {
    for (int i=0;i<10;i++)include[i]=false;
    int x=cur/10;
    while(x) {
        include[x%10]=true;
        x/=10;
    }
}
void chk() {
    for (int i=1;i<=10;i++) {
        cur+=1;
        if (!(cur%10)) set_include();
        if (cur%10==cur_c || include[cur_c])return;
    }
}
void update_i(int& i) {
    string s=to_string(cur);
    for (int j=0;j<s.size();j++) {
        if (s[j]!=input[i]) continue;
        else i++;
    }
}

int main() {
    fastio;
    // read_input;
    cin>>input;
    for (int i=0;i<input.size();update_i(i)) {
        cur_c=input[i]-'0';
        chk();
    }
    cout<<cur;
}
