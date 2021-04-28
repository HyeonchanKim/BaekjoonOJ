#include<iostream>
using namespace std;
typedef unsigned long long ull;
typedef ull(*arr)[2];

arr mat_mult(ull mat1[][2], ull mat2[][2])
{
	static ull result[2][2];
	for(int i=0; i<2; i++)
		for(int j=0; j<2; j++)
			result[i][j] = 0;
        for(int i=0; i<2; i++)
                for(int j=0; j<2; j++)
                        for(int k=0; k<2; k++)
                                result[i][j] = (result[i][j] + mat1[i][k]*mat2[k][j])%1000000007;
	return result;
}

void copy_mat(ull mat1[][2], ull mat2[][2])
{
	for(int i=0; i<2; i++)
		for(int j=0; j<2; j++)
			mat1[i][j] = mat2[i][j];
}

arr power(ull n)
{
	static ull mat[2][2] = {{1, 1}, {1, 0}};
	if(n<2)
		return mat;
	else if(n%2==0)
	{
		ull (*temp)[2] = power(n/2);
		ull half_pow[2][2];
		copy_mat(half_pow, temp);
		return mat_mult(half_pow, half_pow);
	}
	else
	{
		ull (*temp)[2] = power(n/2);
		ull half_pow[2][2];
		copy_mat(half_pow, temp);
		temp = mat_mult(half_pow, half_pow);
		copy_mat(half_pow, temp);
		return mat_mult(half_pow, mat);
	}
}

int main()
{
	ull n;
	cin >> n;
	ull (*ans)[2] = power(n);
	cout << ans[1][0] << "\n";

	return 0;
}
