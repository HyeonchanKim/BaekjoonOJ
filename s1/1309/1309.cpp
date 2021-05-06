#include<cstdio>

int main()
{
	int n;
	scanf("%d", &n);
	int dp[2] = {1, 3};
	for(int i=1; i<n; i++)
	{
		int temp = (dp[1]*2 + dp[0])%9901;
		dp[0] = dp[1];
		dp[1] = temp;
	}
	printf("%d\n", dp[1]);
	return 0;
}
