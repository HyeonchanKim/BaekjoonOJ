#include<cstdio>

int main()
{
	int e, s, m;
	scanf("%d %d %d", &e, &s, &m);
	int x = 1;
	while((x-e) % 15 != 0 || (x-s) % 28 != 0 || (x-m) % 19 != 0)
		x += 1;
	printf("%d\n", x);
	return 0;
}
