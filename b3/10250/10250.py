t = int(input())
result = []
for _ in range(t):
    h, w, n = map(int, input().split())
    y = n%h
    if y == 0:
        y = h
    x = n//h
    if y != h:
        x += 1
    result.append(100*y + x)
for i in result:
    print(i)
