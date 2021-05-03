n = int(input())
people = list(map(int, input().split()))
order = [n]
for i in reversed(range(1, n)):
    count = people[i-1]
    for j in range(len(order)+1):
        if count == 0:
            order.insert(j, i)
            break
        if order[j] > i:
            count -= 1
for i in order:
    print(i, end = ' ')
print()
