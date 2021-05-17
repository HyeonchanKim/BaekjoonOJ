def gcd(m, n):
    while n!= 0:
        t = m%n
        (m,n) = (n,t)
    return abs(m)
x1, x2 = map(int, input().split())
y1, y2 = map(int, input().split())
a = x1*y2 + x2*y1
b = x2*y2
m = gcd(a, b)
print(a//m, b//m)
