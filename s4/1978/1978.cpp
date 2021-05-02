#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int *num = new int[n];
	for(int i=0; i<n; i++)
		cin >> num[i];
	sort(num, num+n);
	bool *prime_num = new bool[num[n-1]+1];
	for(int i=2; i<num[n-1]+1; i++)
		prime_num[i] = true;
	prime_num[1] = false;
	for(int i=2; i<num[n-1]+1; i++)
	{
		if(prime_num[i])
		{
			int temp = i*2;
			while(temp < num[n-1]+1)
			{
				prime_num[temp] = false;
				temp += i;
			}
		}
	}
	int count = 0;
	for(int i=0; i<n; i++)
		if(prime_num[num[i]])
			count ++;
	cout << count << "\n";

	delete[] num;
	delete[] prime_num;
	return 0;
}
