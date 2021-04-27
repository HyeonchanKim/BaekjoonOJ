#include<iostream>
using namespace std;

void swap(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

int main()
{
	int a = 1, b = 1, c = 1;
	while(1)
	{
		cin >> a >> b >> c;
		if(a==0 && b==0 && c==0)
			break;
		if(a>c)
			swap(&a, &c);
		if(b>c)
			swap(&b, &c);
		if(a*a+b*b == c*c)
			cout << "right\n";
		else
			cout << "wrong\n";
	}
	return 0;
}
