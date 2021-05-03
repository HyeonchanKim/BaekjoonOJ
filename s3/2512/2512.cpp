#include<cstdio>
#include<algorithm>

int main()
{
	int n;
	scanf("%d", &n);
	int *budget = new int [n];
	for(int i=0; i<n; i++)
		scanf("%d", &budget[i]);
	std::sort(budget, budget+n);
	int total;
	scanf("%d", &total);
	int answer, iter;
	for(iter = 0; iter < n; iter ++)
	{
		int avg = total/(n-iter);
		answer = budget[iter];
		if(avg>=answer)
			total -= answer;
		else
			break;
	}
	if(iter<n)
		printf("%d\n", total/(n-iter));
	else
		printf("%d\n", answer);

	return 0;
}
