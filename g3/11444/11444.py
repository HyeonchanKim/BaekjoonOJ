def power(n):
    if n <2:
        return mat
    elif n%2==0:
        temp = power(n//2)
        return mul_mat(temp, temp)
    else:
        temp = power(n//2)
        return mul_mat(mul_mat(temp, temp), mat)
def mul_mat(mat1, mat2):
    result = [[0, 0], [0, 0]]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                result[i][j] = (result[i][j] + mat1[i][k]*mat2[k][j])%1000000007
    return result

mat = [[1, 1], [1, 0]]
n = int(input())
print(power(n)[1][0])
