#include<iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int result = 0;
	for(int i=1; i<=n; i++)
	{
		int temp = i;
		int sum = i;
		while(temp > 0)
		{
			sum += temp%10;
			temp /= 10;
		}
		if(sum == n)
		{
			result = i;
			break;
		}
	}
	cout << result << "\n";
	return 0;
}
