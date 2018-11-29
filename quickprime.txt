#include<iostream>
#include<algorithm>
#include<cstdio>
using namespace std;
const long long N=1000000+3;
long long prime[N];
long long dp[N];
void init()
{
    for(long long int i=2;i<N;i++)
    {
        if(dp[i])continue;
        prime[i]=1;
        for(int j=i;i*j<N;j++)
            dp[j*i]=1;
    }
}
int main()
{
    init();
    for(long long i=0;i<10;i++)
    {
        printf("%lld ",prime[i]);

    }
}
