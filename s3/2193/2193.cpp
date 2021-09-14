#include<cstdio>

typedef unsigned long long ull;

int main()
{
	int n;
	scanf("%d", &n);
	ull *end0 = new ull[n+1];
	ull *end1 = new ull[n+1];
	end0[0] = 0;
	end0[1] = 0;
	end0[2] = 1;
	end1[0] = 0;
	end1[1] = 1;
	end1[2] = 0;
	for(int i=3; i<=n; i++)
	{
		end0[i] = end0[i-1] + end1[i-1];
		end1[i] = end0[i-1];
	}
	printf("%lld\n", end0[n] + end1[n]);
	
	delete[] end0;
	delete[] end1;
	return 0;
}
