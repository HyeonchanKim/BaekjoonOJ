#include<cstdio>

int main()
{
	int m, n;
	scanf("%d %d", &m, &n);
	bool *check_prime = new bool[n+1];
	for(int i=2; i<=n; i++)
		check_prime[i] = true;
	check_prime[1] = false;
	check_prime[0] = false;

	int sum_prime = 0;
	int min_prime = 0;
	for(int i=2; i<n+1; i++)
	{
		if(check_prime[i])
		{
			if(i>=m)
			{
				sum_prime += i;
				if(min_prime==0)
					min_prime = i;
			}
			int temp = i*2;
			while(temp <=n)
			{
				check_prime[temp] = false;
				temp += i;
			}
		}
	}
	if(sum_prime == 0)
		printf("-1\n");
	else
		printf("%d\n%d\n", sum_prime, min_prime);

	delete[] check_prime;
	return 0;
}
