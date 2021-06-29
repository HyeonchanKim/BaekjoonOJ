t = int(input())
result = []
def gcd(a, b):
	r = a%b
	if r==0:
		return b
	else:
		return gcd(b, r)
for i in range(t):
	a, b = map(int, input().split())
	result.append(a*b//gcd(a,b))
for i in result:
	print(i)
