#include<iostream>
using namespace std;

int main()
{
	int t;
	cin >> t;
	int *result = new int [t];
	for(int i=0; i<t; i++)
	{
		int k, n;
		cin >> k >> n;
		int **apart = new int* [2];
		apart[0] = new int [n];		//짝수층
		apart[1] = new int [n];		//홀수층

		int floor = 1;
		for(int j=0; j<n; j++)
			apart[0][j] = j+1;
		apart[1][0] = 1;
		for(int j=1; j<n; j++)
			apart[1][j] = apart[0][j] + apart[1][j-1];
		while(floor < k)
		{
			floor += 1;
			int this_floor = floor%2;
			int last_floor = this_floor^1;	//xor연산을 이용해 두 개가 다른 값이 되게 한다.
			for(int j=1; j<n; j++)
				apart[this_floor][j] = apart[last_floor][j] + apart[this_floor][j-1];
		}
		result[i] = apart[floor%2][n-1];
		delete[] apart[0];
		delete[] apart[1];
		delete[] apart;

	}
	for(int i=0; i<t; i++)
		cout << result[i] << "\n";
	delete[] result;
	return 0;
}
