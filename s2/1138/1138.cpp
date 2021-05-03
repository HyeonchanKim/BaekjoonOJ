#include<iostream>
#include<vector>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int *people = new int [n];
	for(int i=0; i<n; i++)
		cin >> people[i];
	vector<int> order = {n};
	vector<int>::iterator iter;
	for(int i=n-1; i>0; i--)
	{
		int count = people[i-1];
		bool check_input = false;
		for(iter = order.begin(); iter != order.end(); iter ++)
		{
			if(count == 0)
			{
				order.insert(iter, i);
				check_input = true;
				break;
			}
			if(*iter > i)
				count --;
		}
		if(!check_input)
			order.insert(order.end(), i);
	}
	for(iter = order.begin(); iter != order.end(); iter++)
		cout << *iter << " ";
	cout << "\n";
	delete[] people;
	return 0;
}
