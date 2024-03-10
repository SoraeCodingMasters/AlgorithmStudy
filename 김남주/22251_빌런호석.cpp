#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <algorithm>

#define fastio cin.tie(0);cout.tie(0);ios::sync_with_stdio(false)
#define read_input freopen("input.txt","r",stdin)
using namespace std;

int N,K,P,X;
bool pos[10][7]={
    {1,1,1,0,1,1,1},
    {0,0,1,0,0,1,0},
    {1,0,1,1,1,0,1},
    {1,0,1,1,0,1,1},
    {0,1,1,1,0,1,0},
    {1,1,0,1,0,1,1},
    {1,1,0,1,1,1,1},
    {1,0,1,0,0,1,0},
    {1,1,1,1,1,1,1},
    {1,1,1,1,0,1,1}
};
int req_n[10][10];
int display[6];
int ans=0, cur=0, cur_p=0;
void sol(int idx) {
    if (idx==K) {
        if (cur && cur!=X) ans++;
        return;
    }
    int cur_num=display[idx];
    int x=pow(10,(K-idx-1));
    for (int i=0;i<=9;i++) {
        if (cur+x*i>N || cur_p+req_n[cur_num][i]>P) continue;
        cur_p+=req_n[cur_num][i];
        cur+=x*i;
        sol(idx+1);
        cur_p-=req_n[cur_num][i];
        cur-=x*i;
    }
}
int main() {
    fastio;
    // read_input;
    cin>>N>>K>>P>>X;
    for (int i=0;i<=9;i++) {
        for (int j=0;j<=9;j++) {
            int rn=0;
            for (int k=0;k<7;k++) {
                if (pos[i][k]!=pos[j][k]) rn++;
            }
            req_n[i][j]=rn;
        }
    }
    int tmp=X;
    for (int i=K-1;i>=0;i--) {
        display[i]=tmp%10;
        tmp/=10;
    }
    sol(0);
    cout<<ans;
}
