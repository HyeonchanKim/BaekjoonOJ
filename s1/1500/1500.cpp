#include<cstdio>

int main()
{
	long long s, k;
	scanf("%lld %lld", &s, &k);
	long long mod = s%k;
	long long answer = 1;
	for(int i=0; i<mod; i++)
		answer *= s/k+1;
	for(int i=0; i<k-mod; i++)
		answer *= s/k;
	printf("%lld\n", answer);
	return 0;
}
