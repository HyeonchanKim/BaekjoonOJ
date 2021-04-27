n = int(input())
result = 0
for i in range(1, n):
    temp = i
    for j in str(i):
        temp += int(j)
    if temp == n:
        result = i
        break
print(result)
