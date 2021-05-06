#include<cstdio>

int main()
{
	int n;
	scanf("%d", &n);
	int *seq = new int[n];
	int *dp = new int[n];
	scanf("%d", &seq[0]);
	dp[0] = seq[0];
	int max = dp[0];
	for(int i=1; i<n; i++)
	{
		scanf("%d", &seq[i]);
		if(dp[i-1] > 0)
			dp[i] = dp[i-1] + seq[i];
		else
			dp[i] = seq[i];
		if(dp[i] > max)
			max = dp[i];
	}
	printf("%d\n", max);

	delete[] seq;
	delete[] dp;
	return 0;
}
