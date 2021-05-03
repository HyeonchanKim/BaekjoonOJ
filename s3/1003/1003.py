t = int(input())
num = []
for i in range(t):
    num.append(int(input()))
answer = []
answer.append([1, 0])
answer.append([0, 1])
for i in range(max(num)-1):
    p0 = answer[i][0] + answer[i+1][0]
    p1 = answer[i][1] + answer[i+1][1]
    answer.append([p0, p1])
for i in num:
    print(answer[i][0], answer[i][1])
