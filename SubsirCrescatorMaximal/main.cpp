#include <fstream>
#include <iostream>
#include <cstdio>
using namespace std;
ifstream f("csmax.txt");
ofstream g("scmax.out");
int n;
int v[100], lung[100];
int main()
{
    FILE *f = fopen("scmax.in", "r");
    fscanf(f, "%d", &n);
    cout<<n<<"\n";
    for(int i = 1; i <= n; i++)
        fscanf(f, "%d", &v[i]);
    for(int i = 1; i <= n; i ++)
        cout << v[i] << " ";
    lung[n] = 1; int maxl;
    for(int i = n-1; i >=1; i++){
        for(int j = i+1; j <=n; j++)
            if(v[i] < v[j] && lung[i] < lung[j]) {lung[i] = lung[j] + 1; maxl = lung[i]; }
    }
    g << maxl << "\n";
    return 0;
}
