#include<iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int count = 1, last_num = 1;
	while(n > last_num)
		last_num += 6*(count++);
	cout << count << "\n";

	return 0;
}
