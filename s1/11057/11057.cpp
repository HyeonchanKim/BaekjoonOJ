#include<cstdio>

int main()
{
	int n;
	scanf("%d", &n);
	int **dp = new int*[n+1];
	for(int i=0; i<=n; i++)
	{
		dp[i] = new int[10];
		for(int j=0; j<10; j++)
			dp[i][j] = 0;
	}
	for(int i=0; i<10; i++)
		dp[1][i] = 1;
	for(int i=2; i<=n; i++)
		for(int j=0; j<10; j++)
			for(int k=j; k<10; k++)
			{
				dp[i][k] += dp[i-1][j];
				dp[i][k] %= 10007;
			}

	int answer = 0;
	for(int i=0; i<10; i++)
		answer += dp[n][i];
	printf("%d\n", answer%10007);

	for(int i=0; i<=n; i++)
		delete[] dp[i];
	delete[] dp;
	return 0;
}
