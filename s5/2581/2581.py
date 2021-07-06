m = int(input())
n = int(input())
check_prime = [True for _ in range(n+1)]
check_prime[0] = False
check_prime[1] = False
sum_prime = 0
min_prime = 0
for i in range(2, n+1):
    if check_prime[i]:
        if i >= m:
            sum_prime += i
            if min_prime == 0:
                min_prime = i
        temp = i*2
        while temp <= n:
            check_prime[temp] = False
            temp += i
if sum_prime == 0:
    print(-1)
else:
    print(sum_prime)
    print(min_prime)
