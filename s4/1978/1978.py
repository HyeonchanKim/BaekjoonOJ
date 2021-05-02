n = int(input())
num = sorted(list(map(int, input().split())))
check_prime = [True for _ in range(num[-1]+1)]
check_prime[1] = False
for i in range(2, num[-1]+1):
    if check_prime:
        temp = i*2
        while temp <= num[-1]:
            check_prime[temp] = False
            temp += i
count = 0
for i in num:
    if check_prime[i]:
        count += 1
print(count)
