e, s, m = map(int, input().split())

x = 1
while not((x-e) % 15 == 0 and (x-s) % 28 == 0 and (x-m) % 19 == 0):
    x += 1
print(x)
