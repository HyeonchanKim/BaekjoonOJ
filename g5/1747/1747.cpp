#include<vector>
#include<cstring>
#include<iostream>
using namespace std;

bool palindrome(int n)
{
	string s1 = to_string(n);
	int nlength = s1.length();
	bool result = true;
	for(int i=0; i<nlength; i++)
		if (s1[i] != s1[nlength-1-i])
		{
			result = false;
			break;
		}
	return result;
}

int main()
{
	int n;
	cin >> n;
	vector<int> prime_number;
	bool *check_prime = new bool[n];
	for (int i=2; i<n; i++)
		check_prime[i] = true;
	for (int i=2; i<n; i++)
	{
		if (check_prime[i])
		{
			prime_number.push_back(i);
			int temp = i*2;
			while (temp < n)
			{
				check_prime[temp] = false;
				temp += i;
			}
		}
	}
	delete[] check_prime;
	int answer = 0;
	int num = n;
	vector<int>::iterator iter;
	while (answer == 0)
	{
		if (palindrome(num))
		{
			answer = num;
			for(iter = prime_number.begin(); iter != prime_number.end(); iter ++)
			{
				int temp = *iter;
				if (num%temp==0)
				{
					answer = 0;
					break;
				}
			}
		}
		num += 1;
	}
	if (answer == 1)
		answer = 2;
	cout << answer << "\n";

	return 0;
}
