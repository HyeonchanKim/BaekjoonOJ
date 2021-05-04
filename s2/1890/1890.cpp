#include<cstdio>
typedef long long ll;

int main()
{
	int n;
	scanf("%d", &n);
	int **pan = new int *[n];
	ll **count_visit = new ll *[n];
	for(int i=0; i<n; i++)
	{
		pan[i] = new int [n];
		count_visit[i] = new ll [n];
		for(int j=0; j<n; j++)
		{
			scanf("%d", &pan[i][j]);
			count_visit[i][j] = 0;
		}
	}
	count_visit[0][0] = 1;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			int jump = pan[i][j];
			if(jump == 0)
				continue;
			if(i+jump < n)
				count_visit[i+jump][j] += count_visit[i][j];
			if(j+jump < n)
				count_visit[i][j+jump] += count_visit[i][j];
		}
	}
	printf("%lld\n", count_visit[n-1][n-1]);
	for(int i=0; i<n; i++)
	{
		delete[] pan[i];
		delete[] count_visit[i];
	}
	delete[] pan;
	delete[] count_visit;
	return 0;
}
