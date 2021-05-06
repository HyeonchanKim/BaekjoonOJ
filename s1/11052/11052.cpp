#include<cstdio>

int main()
{
	int n;
	scanf("%d", &n);
	int *p = new int [n];
	for(int i=0; i<n; i++)
	{
		scanf("%d", &p[i]);
		for(int j=0; j<i; j++)
		{
			int temp = p[i-j-1] + p[j];
			if(temp > p[i])
				p[i] = temp;
		}
	}
	printf("%d\n", p[n-1]);

	delete[] p;
	return 0;
}
