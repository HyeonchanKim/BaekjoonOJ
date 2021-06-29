#include<cstdio>

int gcd(int a, int b)
{
	int r = a%b;
	if(r==0)
		return b;
	else 
		return gcd(b, r);
}

int main()
{
	int t;
	scanf("%d", &t);
	int *result = new int [t];
	for(int i=0; i<t; i++)
	{
		int a, b;
		scanf("%d %d", &a, &b);
		result[i] = a*b/gcd(a, b);
	}
	for(int i=0; i<t; i++)
		printf("%d\n", result[i]);

	delete[] result;
	return 0;
}
