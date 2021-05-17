import sys
n = int(sys.stdin.readline())
todo = []
for i in range(n):
    todo.append(int(sys.stdin.readline()))
check_prime = [True for _ in range(max(todo)+1)]
prime_num = []
for i in range(2, max(todo) + 1):
    if check_prime[i]:
        prime_num.append(i)
        temp = i*2
        while temp <= max(todo):
            check_prime[temp] = False
            temp += i
for i in range(n):
    k = todo[i]
    for j in prime_num:
        count = 0
        if k == 1:
            break
        while k%j == 0:
            count += 1
            k //= j
        if count != 0:
            print(j, count)
