n, m = map(int, input().split())
cards = sorted(list(map(int, input().split())))
result = 0
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            temp = cards[i] + cards[j] + cards[k]
            if temp > m:
                break
            elif temp > result:
                result = temp
print(result)
