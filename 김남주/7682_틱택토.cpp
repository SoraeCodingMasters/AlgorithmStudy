#include <iostream>
#include <cstring>
#include <cmath>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

string s=".........";
bool possible[20000];
char l[2] ={'X','O'};
bool check(char cur) {
    bool f=false;
    for (int r=0;r<3;r++) {
        f=true;
        for (int c=0;c<3;c++) {
            if (s[r*3+c]!=cur) {
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
    if (s[0]==cur&&s[4]==cur&&s[8]==cur) return true;
    if (s[2]==cur&&s[4]==cur&&s[6]==cur) return true;
    return false;
}
void bf(int num, int b, int c) {
    if (num==9) {
        possible[b]=true;
        return;
    }
    if (check('X')) {
        possible[b]=true;
        return;
    }
    if (check('O')) {
        possible[b]=true;
        return;
    }
    int x=1;
    for (int i=0;i<9;i++) {
        if (s[i]=='.') {
            s[i]=l[c];
            bf(num+1,b+x*(c?1:2),c?0:1);
            s[i]='.';
        }
        x*=3;
    }
}

int main() {
    fastio;
    // read_input;
    bf(0,0,0);
    string input;
    while(1) {
        cin>>input;
        if (input.front()=='e') break;
        int idx=0;
        int x=1;
        for (int i=0;i<9;i++) {
            if (input[i]=='X') {
                idx+=x*2;
            } else if (input[i]=='O') {
                idx+=x;
            }
            x*=3;
        }
        if (possible[idx]) cout<<"valid\n";
        else cout<<"invalid\n";
    }
}
