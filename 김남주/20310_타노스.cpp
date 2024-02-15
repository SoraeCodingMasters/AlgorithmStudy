#include <iostream>
#include <list>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)

using namespace std;

string s;
bool p[500] = {false, };

int main()
{
    bool tmp;
    
    int n1=0;
    int n0=0;
    
    cin >> s;
    for (const auto& i: s) {
        if (i == '1') n1++;
        else n0++;
    }
    
    int t1=0,t0=0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '1' && t1++ < n1/2)
            p[i] = true;
        else if (t1 >= n1/2) break;
    }
    for (int i = s.size() -1; i >=0; i--) {
        if (s[i] == '0' && t0++ < n0/2)
            p[i] = true;
        else if (t0 >= n0/2) break;
    }
    
    // 1001110011 => 00110011
    for (int i = 0; i < s.size(); i++) {
        if (p[i]) continue;
        cout << s[i];
    }
    return 0;
}
