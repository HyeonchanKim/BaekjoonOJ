n, k = map(int, input().split())
add = (pow(10, len(str(n))))%k
count = 1
prev = 0
while count <= k:
    prev = ((prev*add)+n)%k
    if prev==0:
        break
    count += 1
print(count if count <=k else -1)
