#include <iostream>
#include <cstring>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

#define MAX 100'000
int n;
bool x[MAX+1],target[MAX+1],tmp[MAX+1];
const int INF=2e9;

int main() {
    fastio;
    // read_input;
    cin>>n;
    char c;
    for (int i=0;i<n;i++) 
        cin>>c,x[i]=c=='1';
    for (int i=0;i<n;i++) 
        cin>>c,target[i]=c=='1';
    
    memcpy(tmp,x,sizeof(x));
    int cur=0;
    for (int i=1;i<n;i++) {
        if (tmp[i-1]!=target[i-1]) {
            tmp[i]=!tmp[i];
            tmp[i+1]=!tmp[i+1];
            cur++;
        }
    }
    if (tmp[n-1]==target[n-1]) {
        cout<<cur;
        return 0;
    }
    cur=1;
    x[0]=!x[0],x[1]=!x[1];
    for (int i=1;i<n;i++) {
        if (x[i-1]!=target[i-1]) {
            x[i]=!x[i];
            x[i+1]=!x[i+1];
            cur++;
        }
    }
    cout << (x[n-1]==target[n-1]?cur:-1);
}
