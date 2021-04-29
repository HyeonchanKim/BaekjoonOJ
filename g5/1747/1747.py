n = int(input())
prime_number = []
numbers = [True for _ in range(n)]
for i in range(2, n):
    if numbers[i]:
        prime_number.append(i)
        temp = i*2
        while temp < n:
            numbers[temp] = False
            temp += i
answer = 0
num = n
while answer == 0:
    if num == int(''.join(reversed(str(num)))):
        answer = num
        for i in prime_number:
            if num%i == 0:
                answer = 0
                break
    num += 1
print(answer if n != 1 else 2)
