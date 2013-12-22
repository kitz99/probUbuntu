#include <fstream>
#include <iostream>
using namespace std;
ifstream f("podm.in");
ofstream g("podm.out");
int n;
long long d[505], cost[505][505];
int main()
{
    f >> n;
    for(int  i = 0 ; i <= n; i ++)
        f >> d[i];
    long long aux = 0;
    for(int j = 2; j <= n; j++){
        for(int i = j-1; i >=1; i--){
            long long m = 0xfffffffffffff;
            for(int k = i; k < j; k++){
                aux = cost[i][k] + cost[k+1][j]+d[i-1]*d[k]*d[j];
                if(aux < m) m = aux;
            }
            cost[i][j] = m;
        }
    }
    g << cost[1][n] <<"\n";
    return 0;
}
