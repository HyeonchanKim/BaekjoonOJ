#include<cstdio>
#include<vector>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	int *todo = new int [n];
	int max = 0;
	for(int i=0; i<n; i++)
	{
		scanf("%d", &todo[i]);
		max = todo[i] > max ? todo[i] : max;
	}
	bool *check_prime = new bool [max+1];
	for(int i=0; i<=max; i++)
		check_prime[i] = true;
	vector<int> prime_number;
	for(int i=2; i<=max; i++)
	{
		if(check_prime[i])
		{
			prime_number.push_back(i);
			int temp = i*2;
			while (temp <=max)
			{
				check_prime[temp] = false;
				temp += i;
			}
		}
	}
	vector<int>::iterator iter;
	for(int i=0; i<n; i++)
	{
		int k = todo[i];
		for(iter = prime_number.begin(); iter != prime_number.end(); iter++)
		{
			int prime = *iter;
			if(k==1)
				break;
			int count = 0;
			while (k%prime == 0)
			{
				count += 1;
				k /= prime;
			}
			if(count!=0)
				printf("%d %d\n", prime, count); 
		}
	}

	delete[] todo;
	delete[] check_prime;
	return 0;
}
