#include<cstdio>

int max(int *dp)
{
	int _max = dp[0]>dp[1]?dp[0]:dp[1];
	_max = _max>dp[2]?_max:dp[2];
	return _max;
}

int main()
{
	int n;
	scanf("%d", &n);
	int *cup = new int [n];
	int **dp = new int *[n];
	for(int i=0; i<n; i++)
	{
		scanf("%d", &cup[i]);
		dp[i] = new int [3];
	}
	dp[0][0] = cup[0];
	dp[0][1] = cup[0];
	dp[0][2] = 0;
	for(int i=1; i<n; i++)
	{
		dp[i][0] = dp[i-1][2] + cup[i];
		dp[i][1] = dp[i-1][0] + cup[i];
		dp[i][2] = max(dp[i-1]);
		delete[] dp[i-1];
	}
	printf("%d\n", max(dp[n-1]));
	delete[] dp[n-1];
	delete[] dp;

	delete[] cup;
	return 0;
}
