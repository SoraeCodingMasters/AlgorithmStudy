#include <iostream>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

string s;

bool check(char cur) {
    bool f=false;
    for (int r=0;r<3;r++) {
        f=true;
        for (int c=0;c<3;c++) {
            if (s[3*r+c]!=cur) {
                f=false;
                break;
            }
        }
        if (f) return true;
    }
    for (int c=0;c<3;c++) {
        f=true;
        for (int r=0;r<3;r++) {
            if (s[r*3+c]!=cur) {
                f=false;
                break;
            }
        }
        if (f) return true;
    }
    if (s[0]==cur && s[4]==cur && s[8]==cur) return true;
    if (s[2]==cur && s[4]==cur && s[6]==cur) return true;
    return false;
}

pair<bool,bool> x_o_f() {
    bool x_f=check('X');
    bool o_f=check('O');
    return {x_f,o_f};
}
int main() {
    fastio;
    // read_input;
    while(1) {
        cin>>s;
        if (s=="end")break;
        int x_n=0,o_n=0;
        for (int i=0;i<9;i++)
            if (s[i]=='O') o_n++;
            else if (s[i]=='X') x_n++;
        if (!(x_n-o_n==1 || x_n==o_n)) {
            cout<<"invalid"<<'\n';
            continue;
        }
        auto [x_f,o_f]=x_o_f();
        if (x_f && x_n-o_n!=1) {
            cout<<"invalid"<<'\n';
            continue;
        }
        if (o_f && x_n!=o_n) {
            cout<<"invalid"<<'\n';
            continue;
        }
        if (!x_f&&!o_f&&x_n+o_n!=9) {
            cout<<"invalid"<<'\n';
            continue;
        }
        cout<<"valid"<<'\n';
    }
}
