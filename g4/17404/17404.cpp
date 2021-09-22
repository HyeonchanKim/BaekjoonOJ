#include<cstdio>

int min(int a, int b)
{return a < b ? a : b;}

int main()
{
	int n;
	scanf("%d", &n);
	int **cost = new int*[n];
	int **dp = new int*[n];
	for(int i=0; i<n; i++)
	{
		cost[i] = new int[3];
		dp[i] = new int[3];
		scanf("%d %d %d", &cost[i][0], &cost[i][1], &cost[i][2]);
	}
	int answer = 10000000;
	for(int color=0; color<3; color++)
	{
		for(int i=0; i<3; i++)
			dp[0][i] = i!=color ? 10000000 : cost[0][i];
		for(int i=1; i<n; i++)
		{
			dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2]);
		        dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1]);
		}
		for(int i=0; i<3; i++)
			if(i != color)
				answer = min(answer, dp[n-1][i]);
	}
	

	printf("%d\n", answer);
	for(int i=0; i<n; i++)
	{
		delete[] cost[i];
		delete[] dp[i];
	}
	delete[] cost;
	delete[] dp;

	return 0;
}
