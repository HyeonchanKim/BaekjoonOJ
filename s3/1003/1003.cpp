#include<iostream>
using namespace std;
struct fibo
{
	int p0;
	int p1;
};

int main()
{
	int t;
	cin >> t;
	int *tc = new int [t];
	int max_num = 0;
	for(int i=0; i<t; i++)
	{
		cin >> tc[i];
		if(tc[i]>max_num)
			max_num = tc[i];
	}
	struct fibo * result = new struct fibo [max_num+2];
	result[0].p0 = 1;
	result[0].p1 = 0;
	result[1].p0 = 0;
	result[1].p1 = 1;
	for(int i=2; i<=max_num; i++)
	{
		result[i].p0 = result[i-1].p0 + result[i-2].p0;
		result[i].p1 = result[i-1].p1 + result[i-2].p1;
	}
	for(int i=0; i<t; i++)
		cout << result[tc[i]].p0 << " " << result[tc[i]].p1 << "\n";

	delete[] result;
	delete[] tc;
	return 0;
}
