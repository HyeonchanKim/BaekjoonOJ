#include<cstdio>

int main()
{
	int n;
	scanf("%d", &n);
	int *box = new int [n];
	int *dp = new int [n];
	for(int i=0; i<n; i++)
	{
		scanf("%d", &box[i]);
		dp[i] = 1;
	}
	int max = 1;
	for(int i=0; i<n; i++)
		for(int j=0; j<i; j++)
			if(box[i]>box[j] && dp[i]<dp[j]+1)
			{
				dp[i] = dp[j] + 1;
				max = dp[i] > max? dp[i] : max;
			}
	printf("%d\n", max);

	delete[] box;
	delete[] dp;
	return 0;
}
