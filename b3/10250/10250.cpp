#include<iostream>
using namespace std;

int main()
{
	int t;
	cin >> t;
	int *result = new int[t];
	for(int i=0; i<t; i++)
	{
		int h, w, n;
		cin >> h >> w >> n;
		int y = n%h;
		if(y==0)
			y = h;
		int x = n/h;
		if(y!=h)
			x += 1;
		result[i] = 100*y + x;
	}
	for(int i=0; i<t; i++)
		cout << result[i] << "\n";
	delete[] result;
	return 0;
}
