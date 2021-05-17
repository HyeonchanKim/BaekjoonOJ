#include<cstdio>

int get_gcd(int a, int b)
{
	if(b==0) return a;
	else return get_gcd(b, a%b);
}

int main()
{
	int x1, x2, y1, y2;
	scanf("%d %d %d %d", &x1, &x2, &y1, &y2);
	int a = x1*y2 + x2*y1, b = x2*y2;
	int gcd = get_gcd(a, b);
	printf("%d %d\n", a/gcd, b/gcd);
	return 0;
}
