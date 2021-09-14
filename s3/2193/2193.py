n = int(input())
end0 = [0, 0, 1, 1]
end1 = [0, 1, 0, 1]

for i in range(4, n+1):
    end0.append(end0[i-1] + end1[i-1])
    end1.append(end0[i-1])
print(end0[n] + end1[n])
