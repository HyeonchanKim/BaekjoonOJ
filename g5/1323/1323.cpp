#include<iostream>
#include<cmath>
using namespace std;
typedef long long ll;

int main()
{
	ll n, k;
	cin >> n >> k;
	int nlength = 0;
	ll tempn = n;
	while(tempn>0)
	{
		nlength += 1;
		tempn/=10;
	}
	ll add = pow(10, nlength);
	add %= k;
	ll count = 1, prev = 0;
	while(count <= k)
	{
		prev = ((prev*add)+n)%k;
		if(prev == 0)
			break;
		count += 1;
	}
	if(count > k)
		count = -1;
	cout << count << "\n";
	return 0;
}
