#include<iostream>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int *cards = new int[n];
	for(int i=0; i<n; i++)
		cin >> cards[i];
	int result = 0;
	for(int i=0; i<n-2; i++)
		for(int j=i+1; j<n-1; j++)
			for(int k=j+1; k<n; k++)
			{
				int temp = cards[i]+cards[j]+cards[k];
				if(temp>result && temp <= m)
					result = temp;
			}
	cout << result << "\n";

	delete[] cards;
	return 0;
}
